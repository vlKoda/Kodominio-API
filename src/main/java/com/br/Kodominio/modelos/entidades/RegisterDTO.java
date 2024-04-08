package com.br.Kodominio.modelos.entidades;

import com.br.Kodominio.modelos.role.Role;

public record RegisterDTO(Long id, String nome, String email, String senha, String telefone, Role role) {
}
