package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Getter
@Log4j2
@Repository
public class TarefaRepositoryMongoDB implements TarefaRepository {
	private TarefaMongoDBSpringRepository tarefaMongoDBSpringRepository;

	public List<Tarefa> buscaTarefaPorIdUsuario(UUID IdUsuario) {
		log.info("[start] TarefaRepositoryMongoDB - buscaTarefaPorIdUsuario ");
		List<Tarefa> listaTarefas = tarefaMongoDBSpringRepository.findAllByIdUsuario(IdUsuario);
		log.info("[finish] TarefaRepositoryMongoDB - buscaTarefaPorIdUsuario ");
		return listaTarefas;
	}
}
