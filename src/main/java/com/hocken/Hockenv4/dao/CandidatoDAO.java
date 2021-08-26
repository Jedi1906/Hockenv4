package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoDAO extends JpaRepository<Candidato,Integer> {
}
