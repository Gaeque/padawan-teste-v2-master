package com.padwan.test.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jedi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Enumerated(EnumType.STRING)
  private Status status;

  private int midichlorians;

  @ManyToOne
  @JoinColumn(name = "mentor_id")
  private Jedi mentor;

  public Jedi(String nome, Status status, int midichlorians, Jedi mentor) {
    this.nome = nome;
    this.status = status;
    this.midichlorians = midichlorians;
    this.mentor = mentor;
  }

  public Jedi() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public int getMidichlorians() {
    return midichlorians;
  }

  public void setMidichlorians(int midichlorians) {
    this.midichlorians = midichlorians;
  }

  @JsonIgnore
  public Jedi getMentor() {
    return mentor;
  }

  public void setMentor(Jedi mentor) {
    this.mentor = mentor;
  }

}
