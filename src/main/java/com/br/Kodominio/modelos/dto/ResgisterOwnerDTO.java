package com.br.Kodominio.modelos.dto;

import com.br.Kodominio.modelos.role.Role;

public record ResgisterOwnerDTO(String nome, String email, String senha, Role role){
}
