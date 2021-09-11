package com.hocken.Hockenv4.security.dao;

import com.hocken.Hockenv4.security.entity.Rol;
import com.hocken.Hockenv4.security.enums.Rolnombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolDAO extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByRolnombre(Rolnombre rolnombre);
}
