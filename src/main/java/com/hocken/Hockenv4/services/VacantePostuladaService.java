package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.dao.VacantePostuladaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VacantePostuladaService {
    @Autowired
    VacantePostuladaDAO vacantePostuladaDAO;
}
