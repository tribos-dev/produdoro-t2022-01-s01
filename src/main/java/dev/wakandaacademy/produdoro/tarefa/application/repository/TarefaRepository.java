package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@Repository
public interface TarefaRepository {
	
	Tarefa salva(Tarefa tarefa);

	Tarefa buscaTarefaPorId(UUID idTarefa);
}