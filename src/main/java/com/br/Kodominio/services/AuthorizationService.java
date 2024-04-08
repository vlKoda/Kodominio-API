package com.br.Kodominio.services;

import com.br.Kodominio.dao.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    IUsuario dao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return dao.findByEmail(email);
    }
}
