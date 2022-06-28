package dev.wakandaacademy.produdoro.tarefa.application.service;

import org.springframework.stereotype.Service;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import java.util.UUID;

@Service
public interface TarefaApplicationService {

	Tarefa adicionaTarefa(Tarefa tarefa);

	void deletaTarefa(UUID idTarefa);

	Tarefa buscaTarefaPoridTarefa(UUID idTarefa);
}