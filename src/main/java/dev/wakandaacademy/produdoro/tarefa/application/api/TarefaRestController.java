package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaApplicationService;
import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class TarefaRestController implements TarefaAPI {
	
	private TarefaApplicationService tarefaApplicationService;

	@Override
	public TarefaDTO adicionaTarefa(@Valid TarefaFORM tarefaFORM) {
		log.info("[start] TarefaRestController - adicionaTarefa");
		Tarefa novaTarefa = tarefaApplicationService.adicionaTarefa(tarefaFORM.toEntity());
		log.info("[finish] TarefaRestController - adicionaTarefa");
		return new TarefaDTO(novaTarefa);
	}
	
}
