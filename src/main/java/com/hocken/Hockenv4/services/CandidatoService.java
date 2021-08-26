package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.dao.CandidatoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidatoService {
    @Autowired
    CandidatoDAO candidatoDAO;
}
