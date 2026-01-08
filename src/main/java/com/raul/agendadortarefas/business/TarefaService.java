package com.raul.agendadortarefas.business;

import com.raul.agendadortarefas.business.dto.TarefaDTO;
import com.raul.agendadortarefas.business.mapper.TarefaConverter;
import com.raul.agendadortarefas.infrastructure.entity.TarefaEntity;
import com.raul.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.raul.agendadortarefas.infrastructure.repository.TarefaRepository;
import com.raul.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefaDTO gravarTarefa(String token, TarefaDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefaEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(
                tarefaRepository.save(entity));
    }
}
