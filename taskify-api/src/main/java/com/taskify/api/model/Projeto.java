package com.taskify.api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Projetos")
public class Projeto {
    
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjeto;
    
    @Column(nullable = false) //no null
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario responsavelTecnico;

    @ManyToMany // many projects -> many users - many users -> many projects
    private List<Usuario> participantes;
}
