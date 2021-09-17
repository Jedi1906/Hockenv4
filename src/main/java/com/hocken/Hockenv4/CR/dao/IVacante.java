package com.hocken.Hockenv4.CR.dao;

import com.hocken.Hockenv4.model.Vacante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IVacante extends CrudRepository<Vacante,Integer> {
    @Query("select v from Vacante v where v.nombre_vac= ?1")
    List<Vacante> getVacanteByNombre_vac(String nombre_vac);
    @Query("select v from Vacante v where v.area = ?1")
    List<Vacante> getVacanteByArea(String area);
 }
