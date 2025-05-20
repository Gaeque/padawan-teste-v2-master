package com.padwan.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padwan.test.dto.MentorAprendizDTO;
import com.padwan.test.dto.QuantidadeStatusDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.repository.JediRepository;

@Service
public class JediService {

  @Autowired
  private JediRepository jediRepository;

  public List<Jedi> getAll() {
    return (List<Jedi>) jediRepository.findAll();
  }

  public List<MentorAprendizDTO> getMestresComAprendizes() {
    return jediRepository.findMentoresComAprendizes();
  }

  public List<Jedi> getJedisComMaisDe9000Midichlorians() {
    return jediRepository.findJedisAcimaDe9000();
  }

  public List<QuantidadeStatusDTO> contarJedisPorStatus() {
    return jediRepository.countByStatus();
  }
}