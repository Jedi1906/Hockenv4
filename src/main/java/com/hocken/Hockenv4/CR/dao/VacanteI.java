package com.hocken.Hockenv4.CR.dao;

import com.hocken.Hockenv4.model.Vacante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacanteI implements IVacanteService {
    @Autowired
    IVacante iVacante;
    @Override
    public List<Vacante> getVacanteByNombre_vac(String nombre_vac) {
        return iVacante.getVacanteByNombre_vac(nombre_vac);
    }

    @Override
    public List<Vacante> getVacanteByArea(String area) {
        return iVacante.getVacanteByArea(area);
    }

}
