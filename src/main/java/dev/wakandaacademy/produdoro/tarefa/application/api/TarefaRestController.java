package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;

public class TarefaRestController implements TarefaAPI {
	
	@Autowired
	private TarefaService tarefaService;

	@Override
	public void editaTarefa(UUID idTarefa, @Valid TarefaFORM tarefaForm) {
		tarefaService.editaTarefa(idTarefa, tarefaForm.toEntity());
	}

}
