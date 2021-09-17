package com.hocken.Hockenv4.services;

import com.hocken.Hockenv4.criterio.FiltroVacante;
import com.hocken.Hockenv4.dao.VacanteDAO;
import com.hocken.Hockenv4.model.Vacante;
import com.hocken.Hockenv4.model.Vacante_;
import io.github.jhipster.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VacanteService extends QueryService<Vacante> {
    /**Servicio de filtros */
    @Autowired
    VacanteDAO vacanteDAO;
    public  List<Vacante> getall(){
        return vacanteDAO.findAll();
    }
    public Page<Vacante> paginas(Pageable pageable){
        return vacanteDAO.findAll(pageable);
    }
    /*Métodos CRUD*/
    public void save(Vacante vacante){
        vacanteDAO.save(vacante);
    }
    public void delete(int id){
        vacanteDAO.deleteById(id);
    }
    public List<Vacante>findByFiltro(FiltroVacante filtroVacante){
        final Specification<Vacante> specification = createSpecification(filtroVacante);
        List<Vacante> vacantes = vacanteDAO.findAll(specification);
        return vacantes;
    }

    /*Retorna todas las vacantes*/
    private Specification<Vacante> createSpecification(FiltroVacante filtroVacante){
        Specification<Vacante>  specification = Specification.where(null);
            /*Filtros a emplear*/
        if(filtroVacante != null){
            if(filtroVacante.getNombre_vac() != null){
            specification = specification.and(buildStringSpecification(filtroVacante.getNombre_vac(), Vacante_.nombre_vac));
            }
            if(filtroVacante.getArea() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getArea(),Vacante_.area));
            }
            if(filtroVacante.getModalidad() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getModalidad(),Vacante_.modalidad));
            }
            if(filtroVacante.getTipo_contrato() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getTipo_contrato(),Vacante_.tipo_contrato));
            }
            if(filtroVacante.getFecha_publ() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getFecha_publ(),Vacante_.fecha_publ));
            }
            if(filtroVacante.getRango_sul() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getRango_sul(),Vacante_.rango_sul));
            }
            if(filtroVacante.getUbicacion() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getUbicacion(),Vacante_.ubicacion));
            }
            if(filtroVacante.getEstado() != null){
                specification = specification.and(buildStringSpecification(filtroVacante.getEstado(),Vacante_.estado));
            }
        }
        return specification;
    }
}
