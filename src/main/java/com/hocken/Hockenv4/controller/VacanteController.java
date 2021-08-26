package com.hocken.Hockenv4.controller;

import com.hocken.Hockenv4.criterio.FiltroVacante;
import com.hocken.Hockenv4.dto.VacanteDTO;
import com.hocken.Hockenv4.model.Vacante;
import com.hocken.Hockenv4.services.VacanteService;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class VacanteController {
        @Autowired
        VacanteService vacanteService;
        @GetMapping(value= "/vacantes")
        public ResponseEntity<List<Vacante>> list(){
            List<Vacante> list = vacanteService.getall();
            return new ResponseEntity<List<Vacante>>(list, HttpStatus.OK);
        }
        @PostMapping(value = "/vacantes")
        public ResponseEntity<List<Vacante>> filtros(@RequestBody VacanteDTO vacanteDTO){
            FiltroVacante filtroVacante = createVacante(vacanteDTO);
            List<Vacante> lis = vacanteService.findByFiltro(filtroVacante);
            return new ResponseEntity<List<Vacante>>(lis,HttpStatus.OK);

        }
            private FiltroVacante createVacante(VacanteDTO dto){
            FiltroVacante fil = new FiltroVacante();
            if(dto != null){
                if(!StringUtils.isBlank(dto.getNombre_vac())){
                    StringFilter filter = new StringFilter();
                    filter.setContains(dto.getNombre_vac());
                    fil.setNombre_vac(filter);
                }
                if(!StringUtils.isBlank(dto.getArea())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getArea());
                    fil.setArea(filter);
                }
                if(!StringUtils.isBlank(dto.getModalidad())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getModalidad());
                    fil.setModalidad(filter);
                }
                if(!StringUtils.isBlank(dto.getTipo_contrato())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getTipo_contrato());
                    fil.setTipo_contrato(filter);
                }
                if(!StringUtils.isBlank(dto.getUbicacion())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getUbicacion());
                    fil.setUbicacion(filter);
                }
                if(!StringUtils.isBlank(dto.getRango_sul())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getRango_sul());
                    fil.setRango_sul(filter);
                }
                if(!StringUtils.isBlank(dto.getFecha_publ())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getFecha_publ());
                    fil.setFecha_publ(filter);
                }
                if(!StringUtils.isBlank(dto.getEstado())){
                    StringFilter filter = new StringFilter();
                    filter.setEquals(dto.getEstado());
                    fil.setEstado(filter);
                }
            }
            return fil;
        }
}
