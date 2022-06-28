package dev.wakandaacademy.produdoro.tarefa.application.repository;

import org.springframework.stereotype.Repository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TarefaRepository {
	Tarefa salva(Tarefa tarefa);
	void deleteById(Tarefa tarefaPorId);
	Optional<Tarefa> buscaTarefaPorId(UUID idTarefa);
}