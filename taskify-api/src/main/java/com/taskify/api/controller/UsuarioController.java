package com.taskify.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.api.model.Usuario;
import com.taskify.api.repository.UsuarioRepository;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
   
    @PostMapping 
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario)); //metod save -> new user in the DB
    }

    @GetMapping 
    public ResponseEntity<Page<Usuario>> listarUsuarios(@PageableDefault(size=5) Pageable paginacao){ // imprimi uma quantidade de páginas
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable("id") Long idUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable("id") Long idUsuario){
        usuarioRepository.deleteById(idUsuario);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){
        Optional <Usuario> usuarioExistente = usuarioRepository.findById(idUsuario);

        if (usuarioExistente.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/email") // or @requestParam("email") - > @GetMapping("/email")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPeloEmail (@RequestParam("email") String email){
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(email);

    if (usuarioExistente.isPresent()){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioExistente);
    } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @Autowired
    private UsuarioRepository usuarioRepository;
}
