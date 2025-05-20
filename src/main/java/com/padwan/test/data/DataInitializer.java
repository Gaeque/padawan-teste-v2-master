package com.padwan.test.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.Status;
import com.padwan.test.repository.JediRepository;

@Component
public class DataInitializer implements CommandLineRunner {

  private final JediRepository jediRepository;

  public DataInitializer(JediRepository jediRepository) {
    this.jediRepository = jediRepository;
  }

  @Override
  public void run(String... args) {
    Jedi yoda = new Jedi("Yoda", Status.MESTRE_JEDI, 12000, null);
    Jedi obiWan = new Jedi("Obi-Wan Kenobi", Status.MESTRE_JEDI, 8000, yoda);
    Jedi anakin = new Jedi("Anakin Skywalker", Status.JEDI, 20000, obiWan);
    Jedi luke = new Jedi("Luke Skywalker", Status.PADAWAN, 4500, yoda);

    jediRepository.save(yoda);
    jediRepository.save(obiWan);
    jediRepository.save(anakin);
    jediRepository.save(luke);
  }
}