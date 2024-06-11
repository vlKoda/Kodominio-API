package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IUsuario;
import com.br.Kodominio.modelos.entidades.Usuario;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Optional<Usuario> usuarioById(@PathVariable Long id){
        return dao.findById(id);
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestParam String autor, @RequestParam String email, @RequestParam String bocorrencia, Usuario usuario){
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getSenha());
        Usuario usuarioCreate = dao.save(usuario);
        return usuarioCreate;
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
