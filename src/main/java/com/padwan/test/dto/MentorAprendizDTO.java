package com.padwan.test.dto;

public class MentorAprendizDTO {
  private String mentor;
  private String aprendiz;

  public MentorAprendizDTO(String mentor, String aprendiz) {
    this.mentor = mentor;
    this.aprendiz = aprendiz;
  }

  public String getMentor() {
    return mentor;
  }

  public void setMentor(String mentor) {
    this.mentor = mentor;
  }

  public String getAprendiz() {
    return aprendiz;
  }

  public void setAprendiz(String aprendiz) {
    this.aprendiz = aprendiz;
  }
}