package com.br.Kodominio.controllers;


import com.br.Kodominio.dao.IOwner;
import com.br.Kodominio.modelos.entidades.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private IOwner dao;

    @GetMapping
    public List<Owner> listarOwner(){
        return (List<Owner>) dao.findAll();
    }

    @PostMapping("/cadastrar")
    public Owner criarOwner(@RequestBody Owner owner){
        Owner ownerCreate = dao.save(owner);
        return ownerCreate;
    }

    @PutMapping("/editar")
    public Owner editarOwner(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,
                             @RequestParam String telefone, Owner owner){
        Owner ownerEdit = dao.save(owner);
        return ownerEdit;
    }

    @DeleteMapping
    public Optional<Owner> deletarOwner(@PathVariable Integer id){
        Optional<Owner> Owner = dao.findById(id);
        dao.findById(id);
        return Owner;
    }


}
