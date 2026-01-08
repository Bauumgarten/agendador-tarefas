package com.raul.agendadortarefas.Controller;

import com.raul.agendadortarefas.business.TarefaService;
import com.raul.agendadortarefas.business.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity <TarefaDTO> gravarTarefas(@RequestBody TarefaDTO dto,
                                                    @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }
}
