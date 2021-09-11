package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.dao.PerfilDAO;
import com.hocken.Hockenv4.model.Perfil_candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PerfilService {
    @Autowired
    PerfilDAO perfilDAO;

    public List<Perfil_candidato> findByArea(String area){
        return perfilDAO.findByArea(area);
    }
    public List<Perfil_candidato> findByCiudad(String ciudad){return perfilDAO.findByCiudad(ciudad);}
    public void save(Perfil_candidato perfil){
        perfilDAO.save(perfil);
    }
    public List<Perfil_candidato> findAll(){return perfilDAO.findAll();}

}
