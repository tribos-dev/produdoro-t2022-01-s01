package dev.wakandaacademy.produdoro.tarefa.application.repository;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@Repository
public interface TarefaRepository {

	Tarefa salva(Tarefa tarefa);

}
