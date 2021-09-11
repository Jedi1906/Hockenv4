package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Perfil_candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilDAO extends JpaRepository<Perfil_candidato,Integer> {
    List<Perfil_candidato> findById(int id);
    List<Perfil_candidato> findByArea(String area);
    List<Perfil_candidato> findByCiudad(String ciudad);
    List<Perfil_candidato> findAll();
}
