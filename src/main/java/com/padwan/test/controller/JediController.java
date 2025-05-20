package com.padwan.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.dto.MentorAprendizDTO;
import com.padwan.test.dto.QuantidadeStatusDTO;
import com.padwan.test.entity.Jedi;

import com.padwan.test.service.JediService;

@RestController
@RequestMapping("/jedis")
public class JediController {

  @Autowired
  private JediService jediService;

  @GetMapping
  public List<Jedi> listarTodos() {
    return jediService.getAll();
  }

  @GetMapping("/mestres-e-aprendizes")
  public List<MentorAprendizDTO> mestresEAprendizes() {
    return jediService.getMestresComAprendizes();
  }

  @GetMapping("/acima-de-9000")
  public List<Jedi> jedisAcimaDe9000() {
    return jediService.getJedisComMaisDe9000Midichlorians();
  }

  @GetMapping("/quantidade-por-status")
  public List<QuantidadeStatusDTO> contarPorStatus() {
    return jediService.contarJedisPorStatus();
  }
}