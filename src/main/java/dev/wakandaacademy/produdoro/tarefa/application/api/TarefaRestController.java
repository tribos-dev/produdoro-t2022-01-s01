package dev.wakandaacademy.produdoro.tarefa.application.api;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaApplicationService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Log4j2
@RestController
@AllArgsConstructor
public class TarefaRestController implements TarefaAPI {
    private TarefaApplicationService tarefaApplicationService;

    @Override
    public void defineTarefaAtiva(UUID idUsuario, UUID idTarefa) {
        log.info("[start] TarefaRestController - defineTarefaAtiva");
        tarefaApplicationService.ativaTarefa(idUsuario, idTarefa);
        log.info("[finish] TarefaRestController - defineTarefaAtiva");
    }

    @Override
    public TarefaResponse adicionaTarefa(@Valid TarefaRequest tarefaRequest) {
        log.info("[inicia] TarefaRestController - adicionaTarefa");
        Tarefa novaTarefa = tarefaApplicationService.adicionaTarefa(tarefaRequest.toEntity());
        log.info("[finaliza] TarefaRestController - adicionaTarefa");
        return new TarefaResponse(novaTarefa);
    }

    @Override
    public void deletaTarefa(UUID idTarefa) {
        log.info("[start] TarefaRestController - deletaTarefa");
        tarefaApplicationService.deletaTarefa(idTarefa);
        log.info("[finish] TarefaRestController - deletaTarefa");
    }
}