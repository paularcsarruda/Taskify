package com.taskify.api.model;

import com.taskify.api.constants.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor; //dep for reduce code lines
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters and setters from lombok
@NoArgsConstructor
@AllArgsConstructor //contructors and args
@Entity(name = "usuarios") //table on data base
public class Usuario {
    
    @Id //pk - jakarta
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generaty the id's randonly (pk)
    private long idUsuario;
   
    @Column(nullable = false) //no null
    private String nome;
   
    @Column(nullable = false)
    private String sobrenome;
    
    @Column(nullable = false, unique = true) //all user must have an email and its has to be unique
    private String email;
    
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Embedded //embutido da class Endereço
    private Endereco endereco;
    
}
