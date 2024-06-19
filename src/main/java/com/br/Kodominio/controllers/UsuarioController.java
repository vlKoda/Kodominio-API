package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.ICondominio;
import com.br.Kodominio.dao.IUsuario;
import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.entidades.Usuario;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
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
    @CrossOrigin
    public List<Usuario> listarUsuario(){
        return (List<Usuario>) dao.findAll();
    }

    @GetMapping("/listar/{id}")
    @CrossOrigin
    public ResponseEntity<?> usuarioById(@PathVariable Long id){
        Optional<Usuario> optionalUsuario = dao.findById(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar/condominio/{idCondominio}")
    @CrossOrigin
    public ResponseEntity<?> listarPorCondominio(@PathVariable Integer idCondominio){
        List<Usuario> listUserCondo = dao.findAllByCondominioId(idCondominio);

        if (listUserCondo.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(listUserCondo);
        }
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

    @DeleteMapping("/{id}")
    @Transactional
    @CrossOrigin
    public ResponseEntity<Optional<Usuario>> deletarUsuario(@PathVariable Long id){
        Optional<Usuario> Usuario = dao.findById(id);
        dao.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
