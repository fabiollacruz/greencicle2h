package com.greencicle.tcc.greencicle2h.repository;


import com.greencicle.tcc.greencicle2h.model.Usuario;
import com.greencicle.tcc.greencicle2h.repository.UsuarioRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greencicle.tcc.greencicle2h.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
@Query (value = "select * form usuario c.where c.email=? and c.senha", nativeQuery = true)
Usuario findByLogin(String email, String senha);


}
