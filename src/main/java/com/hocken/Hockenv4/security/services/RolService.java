package com.hocken.Hockenv4.security.services;

import com.hocken.Hockenv4.security.dao.RolDAO;
import com.hocken.Hockenv4.security.entity.Rol;
import com.hocken.Hockenv4.security.enums.Rolnombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolDAO rolDAO;

    public Optional<Rol> getByRolnombre(Rolnombre rolnombre){
        return rolDAO.findByRolnombre(rolnombre);
    }
}
