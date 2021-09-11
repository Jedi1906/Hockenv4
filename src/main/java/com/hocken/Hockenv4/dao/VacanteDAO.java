package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Vacante;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacanteDAO extends JpaRepository<Vacante,Integer>, JpaSpecificationExecutor<Vacante> {
}
