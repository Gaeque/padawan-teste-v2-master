# padawan-teste-v2

## 🚀 Como rodar a aplicação

```bash
# Clone o repositório
git clone https://gitlab.com/glauco-pacto/padawan-teste-v2.git
cd padawan-teste-v2

# Rode o Docker para subir a base de dados
docker compose up -d

# Compile o projeto e baixe as dependências
mvn clean install

# Rode a aplicação
mvn spring-boot:run
```

> 💡 Certifique-se de ter o Docker e o Maven instalados na sua máquina.

---

## 🧩 Respostas ao Desafio

### ✅ Primeira questão: Subir a aplicação

Baixei o repositório em formato ZIP e abri no VSCode (também possuo familiaridade com IntelliJ).  
Executei o comando `mvn clean install` para baixar as dependências e identificar quais seriam necessárias.  
Foi necessário adicionar as seguintes dependências no `pom.xml`:

```xml
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
```

Após isso, rodei a aplicação normalmente.

---

### ✅ Segunda questão: Retorno do POST em `/generic-post`

Ao requisitar passando o body completo na requisição, este foi meu retorno:

```json
{
    "planetAbreviado": "Coruscant",
    "rankingMultiplicado": 37944,
    "classeAbreviado": "Jedi"
}
```

---

### ✅ Terceira questão: O que acontece se o `ranking` for 0?

Caso o valor de `ranking` seja alterado para 0, o retorno será:

```http
Status: 500 Internal Server Error
erro ao processar o generico
```

Esse erro ocorre porque, no Service responsável, o ranking é utilizado em uma divisão. Como o valor é 0, ocorre uma divisão por zero, o que não é permitido em Java.

---

### ✅ Quarta questão: Como mudar a porta da aplicação?

Podemos alterar a porta da aplicação modificando a seguinte linha no arquivo `application.properties`:

```properties
server.port=9099
```

Também seria possível fazer isso via `application.yml`, caso a configuração estivesse nesse formato.

---

### ✅ Quinta questão: Criar endpoint com minhas habilidades

Criei um novo Service chamado `GaequeService` junto de um controller com o endpoint GET:

```
http://localhost:9099/gaeque/skills
```

O retorno é um objeto com algumas skills de Dragon Ball:

```json
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
```

---

### ✅ Sexta, Sétima e Oitava Questões: Queries com Native SQL

- Criei duas novas Entities: `Status` e `Jedi` (camada de models)
- Adicionei um Repository com consultas utilizando Native SQL
- No Service, injetei o Repository e criei os métodos:
  - `getMestresComAprendizes`
  - `getJedisComMaisDe9000Midichlorians`
  - `contarJedisPorStatus`
- No Controller, criei os respectivos endpoints:
  - Listar todos os mestres Jedis e seus aprendizes
    ```
    GET /relatorios/mestres-e-aprendizes
    ```
  - Listar todos os Jedis com midichlorians acima de 9000
   ```
    GET /relatorios/jedis-acima-9000
    ```
  - Listar, por status, a quantidade de Jedis
    ```
    GET /relatorios/jedis-por-status
    ```

---

🧙‍♂️ Que a força esteja com você!
