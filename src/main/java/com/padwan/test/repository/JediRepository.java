package com.padwan.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.padwan.test.dto.MentorAprendizDTO;
import com.padwan.test.dto.QuantidadeStatusDTO;
import com.padwan.test.entity.Jedi;

public interface JediRepository extends JpaRepository<Jedi, Long> {

  @Query("SELECT new com.padwan.test.dto.MentorAprendizDTO(j2.nome, j1.nome) FROM Jedi j1 JOIN j1.mentor j2 WHERE j2.status = com.padwan.test.entity.Status.MESTRE_JEDI")
  List<MentorAprendizDTO> findMentoresComAprendizes();

  @Query("SELECT j FROM Jedi j WHERE j.midichlorians > 9000")
  List<Jedi> findJedisAcimaDe9000();

  @Query("SELECT new com.padwan.test.dto.QuantidadeStatusDTO(j.status, COUNT(j)) FROM Jedi j GROUP BY j.status")
  List<QuantidadeStatusDTO> countByStatus();
}