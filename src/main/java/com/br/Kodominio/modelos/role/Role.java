package com.br.Kodominio.modelos.role;

public enum Role {
    // Especificando os tipos de role e criando construtor e Getter
    OWNER("owner"),
    ADMIN("admin"),
    MORADOR("morador"),
    PORTEIRO("porteiro"),
    SINDICO("sindico");

    private final String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
