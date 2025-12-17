package com.raul.agendadortarefas.infrastructure.security;

import com.estudo_raul.java.infrastructure.entity.Usuario;
import com.raul.agendadortarefas.business.dto.UsuarioDTO;
import com.raul.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl{

    @Autowired
    private UsuarioClient client;


    public UserDetails carregaDadosUsuario(String email, String token){
        UsuarioDTO usuarioDTO = client.buscausuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
