package com.br.Kodominio.modelos.dto;

import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.role.Role;

public record RegisterDTO(Long id, String nome, String email, String senha, String telefone, String condominio, String apartamento, Role role) {
}
