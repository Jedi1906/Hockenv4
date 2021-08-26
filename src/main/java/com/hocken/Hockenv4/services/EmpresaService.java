package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.dao.EmpresaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpresaService {
    @Autowired
    EmpresaDAO empresaDAO;
}
