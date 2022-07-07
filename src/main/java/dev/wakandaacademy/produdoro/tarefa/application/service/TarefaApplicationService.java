package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaResponse;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@Service
public interface TarefaApplicationService {

	Tarefa adicionaTarefa(Tarefa tarefa);

	Tarefa editaTarefa(UUID idTarefa, TarefaRequest tarefaRequest);
}