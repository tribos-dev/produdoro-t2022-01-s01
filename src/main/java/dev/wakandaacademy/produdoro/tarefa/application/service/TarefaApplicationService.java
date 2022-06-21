package dev.wakandaacademy.produdoro.tarefa.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@Service
public interface TarefaApplicationService {

	Tarefa adicionaTarefa(Tarefa tarefa);

}
