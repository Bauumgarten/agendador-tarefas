package com.raul.agendadortarefas.infrastructure.security;

import com.raul.agendadortarefas.business.dto.UsuarioDTO;
import com.raul.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token) {
        // GARANTIA: Se o token não tiver o prefixo, adicione-o aqui
        String tokenCompleto = token.startsWith("Bearer ") ? token : "Bearer " + token;

        // Agora a chamada vai com o formato que o outro serviço exige
        UsuarioDTO usuarioDTO = client.buscausuarioPorEmail(email, tokenCompleto);

        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();
    }
}