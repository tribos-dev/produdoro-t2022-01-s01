package dev.wakandaacademy.produdoro.tarefa.application.repository;
import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
public interface TarefaRepository {
	Optional<Tarefa> buscaTarefaPorId(UUID idTarefa);
	void desativaTarefas(UUID idUsuario);
	void salva(Tarefa tarefaPorId);
	

}
