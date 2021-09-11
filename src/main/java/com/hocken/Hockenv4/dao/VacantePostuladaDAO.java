package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Vacante;
import com.hocken.Hockenv4.model.VacantePostulada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacantePostuladaDAO extends JpaRepository<Vacante,Integer> {

}
