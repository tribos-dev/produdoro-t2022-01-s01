package dev.wakandaacademy.produdoro.tarefa.application.service;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
public interface TarefaApplicationService {
	Tarefa ativaTarefa(UUID idTarefa, UUID idUsuario);
}
