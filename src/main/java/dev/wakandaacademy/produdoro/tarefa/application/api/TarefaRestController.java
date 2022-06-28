package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaApplicationService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

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
	public void deletaTarefa(UUID idTarefa) {
		log.info("[start] TarefaRestController - deletaTarefa");
		tarefaApplicationService.deletaTarefa(idTarefa);
		log.info("[finish] TarefaRestController - deletaTarefa");
	}
}