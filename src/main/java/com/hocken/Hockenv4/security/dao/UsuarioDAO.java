package com.hocken.Hockenv4.security.dao;

import com.hocken.Hockenv4.model.Perfil_candidato;
import com.hocken.Hockenv4.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    @Override
    List<Usuario> findAll();
}
