package com.hocken.Hockenv4.CR.dao;

import com.hocken.Hockenv4.model.Vacante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacanteI implements IVacanteService {
    @Autowired
    IVacante iVacante;
    @Override
    public List<Vacante> getVacanteByNombre_vac(String nombre_vac) {
        return iVacante.getVacanteByNombre_vac(nombre_vac);
    }
}
