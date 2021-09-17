package com.hocken.Hockenv4.controller;

import com.hocken.Hockenv4.CR.dao.VacanteI;
import com.hocken.Hockenv4.criterio.FiltroVacante;
import com.hocken.Hockenv4.dto.Mensajes;
import com.hocken.Hockenv4.dto.VacanteDTO;
import com.hocken.Hockenv4.model.Empresa;
import com.hocken.Hockenv4.model.Vacante;
import com.hocken.Hockenv4.services.EmpresaService;
import com.hocken.Hockenv4.services.VacanteService;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( value = "/api")
@CrossOrigin(origins = "*")
public class VacanteController {
        @Autowired
        VacanteI vacanteI;

        @Autowired
        VacanteService vacanteService;
        @Autowired
    EmpresaService empresaService;
        /*Falta insertar ID de vacante*/
        @PostMapping("/nuevaVacante")
        public ResponseEntity<?> nueva(@Valid @RequestBody VacanteDTO dto, BindingResult binding){
            if(binding.hasErrors())
                return new ResponseEntity(new Mensajes("Campos mal colocados o email incorrecto"), HttpStatus.BAD_REQUEST);
            Empresa empresa =
                    new Empresa(dto.getNombre_empresa(),dto.getTitular(),dto.getEmail(),dto.getTelefono(),dto.getPosicion_reclutar(),dto.getRengo_sueldo());
            Vacante vacante = new
                    Vacante(dto.getNombre_vac(),dto.getUbicacion(),dto.getModalidad(),dto.getRango_sul(),dto.getArea(),
                    dto.getDescripcion(),dto.getFecha_publ(),dto.getTipo_contrato(),dto.getPerfil_ideal(),dto.getOfrecemos(),
                    dto.getEstado(),empresa);
            vacanteService.save(vacante);
            empresaService.save(empresa);
            return new ResponseEntity(new Mensajes("Empresa registrada con exito"),HttpStatus.CREATED);
        }


        @GetMapping(value = "/listar")
        public ResponseEntity<Page<Vacante>> vacantes(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "3") int size,
                @RequestParam(defaultValue = "ubicacion") String order,
                @RequestParam(defaultValue = "true") boolean asc
        ){
            Page<Vacante> vacantePage = vacanteService.paginas(
                    PageRequest.of(page,size, Sort.by(order)));
            if(!asc)
                vacantePage = vacanteService.paginas(PageRequest.of(page,size,Sort.by(order).descending()));
                return new ResponseEntity(vacantePage,HttpStatus.OK);
        }

        @GetMapping(value = "/vacante/{nombre_vac}")
        public List<Vacante> getVacanteByNombre(@PathVariable String nombre_vac){
            return vacanteI.getVacanteByNombre_vac(nombre_vac);
        }
        @GetMapping(value= "/vacantes")
        public ResponseEntity<List<Vacante>> list(){
            List<Vacante> list = vacanteService.getall();
            return new ResponseEntity(list, HttpStatus.OK);
        }
        @GetMapping("/vacanteA/{area}")
        public List<Vacante> getVacanteByArea(@PathVariable String area){
            return vacanteI.getVacanteByArea(area);
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
