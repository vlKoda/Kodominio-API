package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IUsuario;
import com.br.Kodominio.infra.security.TokenService;
import com.br.Kodominio.modelos.dto.AuthenticationDTO;
import com.br.Kodominio.modelos.dto.LoginResponseDTO;
import com.br.Kodominio.modelos.dto.RegisterDTO;
import com.br.Kodominio.modelos.entidades.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuario dao;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.dao.findByEmail(data.email()) != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.nome(), data.email(), encryptedPassword, data.telefone(), data.role());

        this.dao.save(novoUsuario);

        return ResponseEntity.ok().build();
    }
}
