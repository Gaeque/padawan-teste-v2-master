package com.padwan.test.dto;

import com.padwan.test.entity.Status;

public class QuantidadeStatusDTO {
  private Status status;
  private Long quantidade;

  public QuantidadeStatusDTO(Status status, Long quantidade) {
    this.status = status;
    this.quantidade = quantidade;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }
}