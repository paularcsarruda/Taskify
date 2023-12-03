package com.taskify.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskify.api.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
   

    @Query("SELECT P FROM projetos p WHERE p.resposavelTecnico.idUsuario = :id")
    Optional<List<Projeto>> findByResponsavelTecnico(@Param("id") Long idUsuario);
}
