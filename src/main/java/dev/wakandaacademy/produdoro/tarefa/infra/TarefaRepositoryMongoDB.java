package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public class TarefaRepositoryMongoDB implements TarefaRepository {

	public List<Tarefa> buscaTarefaPorIdUsuario(UUID IdUsuario) {
		List<Tarefa> listaTarefas = tarefaMongoDBSpringRepository.findAllByIdUsuario(IdUsuario);
		return listaTarefas;
	}

}
