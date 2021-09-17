package com.hocken.Hockenv4.CR.dao;

import com.hocken.Hockenv4.model.Vacante;

import java.util.List;
import java.util.Optional;

public interface IVacanteService {
    List<Vacante> getVacanteByNombre_vac(String nombre_vac);
    List<Vacante> getVacanteByArea(String area);
}
