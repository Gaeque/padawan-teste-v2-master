package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GaequeService {

  public List<String> skills() {
    List<String> skills = new ArrayList<>();
    skills.add("Kamehameha");
    skills.add("Kaioken");
    skills.add("Spirit Bomb");
    skills.add("Final Flash");
    skills.add("Instant Transmission");
    skills.add("Super Saiyan");
    skills.add("Super Saiyan 2");
    return skills;
  }
}
