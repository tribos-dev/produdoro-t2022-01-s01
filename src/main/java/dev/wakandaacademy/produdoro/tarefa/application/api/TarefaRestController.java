package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TarefaRestController implements TarefaAPI {
	
	private TarefaService tarefaService;

	@Override
	public TarefaDTO adicionaTarefa(@Valid TarefaFORM tarefaFORM) {
		TarefaDTO novaTarefa = tarefaService.adicionaTarefa(tarefaFORM.toEntity());
		return novaTarefa;
	}

}
