package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.CR.dao.ICandidatoService;
import com.hocken.Hockenv4.dao.CandidatoDAO;
import com.hocken.Hockenv4.dto.CandidatoDTO;
import com.hocken.Hockenv4.model.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class CandidatoService implements ICandidatoService {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void AddCandidato(Candidato candidato) {
    entityManager.merge(candidato);
    }
}
