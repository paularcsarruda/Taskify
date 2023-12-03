package com.taskify.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taskify.api.constants.Prioridade;
import com.taskify.api.constants.Situacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Tarefas")
public class Tarefa {
    
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @Column(nullable = false) //no null //length = 100 (can be stabilished a length for the char)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy") //pattern bazilian`s date
    private LocalDate dataCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy") //pattern bazilian`s date
    private LocalDate dataConclusao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne(optional = true) // a user can have many tasks (many tasks -> one user)
    @JoinColumn(name = "idUsuario") 
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProjeto")
    private Projeto projeto;
}

