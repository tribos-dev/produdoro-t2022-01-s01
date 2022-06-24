package dev.wakandaacademy.produdoro.tarefa.application.service;
import java.util.UUID;

import javax.validation.Valid;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
public interface TarefaApplicationService {
	void ativaTarefa(UUID idTarefa, UUID idUsuario);
	void salvaTarefa(@Valid Tarefa tarefa);
	Tarefa buscaTarefaPoridTarefa(UUID idTarefa);
}
