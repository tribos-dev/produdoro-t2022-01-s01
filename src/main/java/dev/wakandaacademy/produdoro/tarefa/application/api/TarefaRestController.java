package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TarefaRestController implements TarefaAPI {
	
	private TarefaService tarefaService;

	@Override
	public TarefaDTO adicionaTarefa(@Valid TarefaFORM tarefaFORM) {
		Tarefa novaTarefa = tarefaService.adicionaTarefa(tarefaFORM.toEntity());
		return new TarefaDTO(novaTarefa);
	}

}
