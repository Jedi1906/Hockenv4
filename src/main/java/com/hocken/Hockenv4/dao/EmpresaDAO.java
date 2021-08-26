package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaDAO extends JpaRepository<Empresa,Integer> {
}
