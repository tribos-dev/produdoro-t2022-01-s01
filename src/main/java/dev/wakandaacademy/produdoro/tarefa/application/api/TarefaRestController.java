package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaApplicationService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class TarefaRestController implements TarefaAPI {
	private TarefaApplicationService tarefaApplicationService;

	@Override
	public TarefaResponse adicionaTarefa(@Valid TarefaRequest tarefaRequest) {
		log.info("[inicia] TarefaRestController - adicionaTarefa");
		Tarefa novaTarefa = tarefaApplicationService.adicionaTarefa(tarefaRequest.toEntity());
		log.info("[finaliza] TarefaRestController - adicionaTarefa");
		return new TarefaResponse(novaTarefa);
	}
	
	@Override
	public TarefaResponse editaTarefa(UUID idTarefa, @Valid TarefaRequest tarefaRequest) {
		log.info("[Start] TarefaRestController - editaTarefa");
		Tarefa tarefa = tarefaApplicationService.editaTarefa(idTarefa, tarefaRequest);
		log.info("[Finish] TarefaRestController - editaTarefa");
		return new TarefaResponse(tarefa);
	}

}