package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.dao.EmpresaDAO;
import com.hocken.Hockenv4.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaService {
    @Autowired
    EmpresaDAO empresaDAO;

    public List<Empresa> findAll(){return empresaDAO.findAll();}
    public void save(Empresa empresa){empresaDAO.save(empresa);}
    public void remove(int id){empresaDAO.deleteById(id);}
}
