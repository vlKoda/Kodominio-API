package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IUsuario;
import com.br.Kodominio.modelos.dto.RegisterDTO;
import com.br.Kodominio.modelos.entidades.Usuario;
import com.br.Kodominio.modelos.role.Role;
import com.br.Kodominio.services.EmailService;
import com.br.Kodominio.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UsuarioService service;

    @Autowired
    private EmailService emailService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuario(){
        List<Usuario> listaUsuario = service.listarUsuario();
        if(listaUsuario.isEmpty()){
        return ResponseEntity.noContent().build();
        }else {
        return ResponseEntity.ok(listaUsuario);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        Optional<Usuario> usuarioListar = service.listarPorId(id);
        if(usuarioListar.isPresent()){
        return ResponseEntity.ok(usuarioListar);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar/condominio/{idCondominio}")
    public ResponseEntity<?> listarPorCondominio(@PathVariable Integer idCondominio){
        List<Usuario> listUserCondo = dao.findAllByCondominioId(idCondominio);

        if (listUserCondo.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(listUserCondo);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid RegisterDTO data){
        if(this.dao.findByEmail(data.email()) != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if(data.role() == Role.OWNER && data.condominio() != null && data.apartamento() != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.nome(), data.email(), encryptedPassword, data.telefone(), data.condominio(), data.apartamento(), data.role());

        this.dao.save(novoUsuario);

        emailService.enviarEmailTexto(novoUsuario.getEmail(), "Usuário cadastrrado", "Bem-vindo à nossa plataforma. Sua senha de acesso: " + data.senha());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioEdit = service.editarUsuario(usuario);
        return ResponseEntity.ok(usuarioEdit);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
