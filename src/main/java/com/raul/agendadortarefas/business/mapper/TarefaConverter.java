package com.raul.agendadortarefas.business.mapper;

import com.raul.agendadortarefas.business.dto.TarefaDTO;
import com.raul.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface TarefaConverter {

    TarefaEntity paraTarefaEntity (TarefaDTO dto);

    TarefaDTO paraTarefaDTO (TarefaEntity entity);

    List<TarefaEntity> paraListaTarefasEntity(List<TarefaDTO> dtos);

    List<TarefaDTO> paraListaTarefasDTO(List<TarefaEntity> entities);
}
