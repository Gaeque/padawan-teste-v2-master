# padawan-teste-v2

# Clone o repositório
git clone https://gitlab.com/glauco-pacto/padawan-teste-v2.git
cd padawan-teste-v2

# Rode o Docker para subir a base de dados
docker compose up -d

# Compile o projeto e baixe as dependências
mvn clean install

# Rode a aplicação
mvn spring-boot:run

## 🧩 Respostas ao Desafio

### ✅ Primeira questão: Subir a aplicação


  Para rodar a aplicação baixei o repositorio em formato zip e abri no meu vscode(também possuo familiaridade com Intellij)
	Rodei o comando mvn clean install para baixar as dependencias e saber quais dependencias precisaria instalar
	Encontrei a necessidade em instalar essas duas dependencias, uma do json e a outra para usar um banco de dados
	Após isso, rodei a aplicação normalmente
	as duas dependencias que precisei adicionar ao pom.xml: 
	
	<dependency>
		<groupId>org.json</groupId>
			<artifactId>json</artifactId>
		<version>20230227</version>
	</dependency>
	
	<dependency>
        <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
	
### ✅ Segunda questão: Retorno do POST em `/generic-post`

	ao requisitar passando o body completo na requisição este é meu retorno: 
	
		{
			"planetAbreviado": "Coruscant",
			"rankingMultiplicado": 37944,
			"classeAbreviado": "Jedi"
		}

### ✅ Terceira questão: O que acontece se o `ranking` for 0?

	Caso haja alteração do "ranking" para 0, esse é o retorno: 
	
		Status: 500 Internal Server Error
		erro ao processar o generico
	
	Esse erro acontece por que no Service dessa requisição, o valor do ranking é usado em uma conta de divisão, quando o valor é 0, estamos dividindo por 0, o que não é permitido pelo Java.


### ✅ Quarta questão: Como mudar a porta da aplicação?

	Existem várias formas de alterar em qual porta nossa aplicação subirá
	no repositorio atual nós podemos mudar em application.properties a seguinte linha de código: server.port=9099, para a porta que desejamos subir desde que nenhum outro serviço esteja usando essa determinada porta.
	Também é possível alterar no application.yml caso a aplicação estivesse em YAML.
	
### ✅ Quinta questão: Criar endpoint com minhas habilidades

	Criei um novo Service chamado GaequeService junto de um controller com o endpoint do tipo GET : http://localhost:9099/gaeque/skills
	Como retorno adicionei algumas skills do Dragon Ball e me retorna um objeto nesse formato: 
		{
			"Gaeque Luan": [
				"Kamehameha",
				"Kaioken",
				"Spirit Bomb",
				"Final Flash",
				"Instant Transmission",
				"Super Saiyan",
				"Super Saiyan 2"
			]
		}
	
### ✅ Sexta, Sétima e Oitava Questões: Queries com Native SQL
 
	Adicionei duas novas Entity: Status e Jedi onde é minha camada de models
	Adicionei um Repository onde fiz as consultas usando o Native SQL
	Usando a camada de Services injetei meu repository e chamei os métodos pedidos na questão, sendo eles: getMestresComAprendizes, getJedisComMaisDe9000Midichlorians, contarJedisPorStatus
	Então fiz o Controller onde criei respectivos endpoints para: Listar todos os mestres Jedis e seus aprendizes; Listar todos Jedis cujo midichlorians sejam acima de 9000; Listar por categoria, quantos são os Jedis;
	




