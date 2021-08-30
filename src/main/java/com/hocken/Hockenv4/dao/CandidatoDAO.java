package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Candidato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CandidatoDAO  {
        void AddCandidato(Candidato candidato);
}
