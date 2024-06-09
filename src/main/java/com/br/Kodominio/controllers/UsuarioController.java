package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IUsuario;
import com.br.Kodominio.modelos.dto.RegisterDTO;
import com.br.Kodominio.modelos.entidades.Usuario;
import com.br.Kodominio.modelos.role.Role;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuario dao;

    @GetMapping("/listar")
    public List<Usuario> listarUsuario(){
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid RegisterDTO data){
        if(this.dao.findByEmail(data.email()) != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if(data.role() == Role.OWNER && data.condominio() != null && data.apartamento() != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.nome(), data.email(), encryptedPassword, data.telefone(), data.condominio(), data.apartamento(), data.role());

        this.dao.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioEdit = dao.save(usuario);
        return usuarioEdit;
    }

    @DeleteMapping("/deletar/{id}")
    public Optional<Usuario> deletarUsuario(@PathVariable Long id){
        Optional<Usuario> Usuario = dao.findById(id);
        dao.deleteById(id);
        return Usuario;
    }
}
