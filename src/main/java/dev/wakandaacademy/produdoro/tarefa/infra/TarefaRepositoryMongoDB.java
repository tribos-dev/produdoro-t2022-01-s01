package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TarefaRepositoryMongoDB  implements TarefaRepository{
	
	private TarefaMongoDBSpringRepository tarefaMongoDBSpringRepository;

	@Override
	public Optional<Tarefa> buscaTarefaPorId(UUID idTarefa) {
		log.info("[start] TarefaRepositoryMongoDB - buscaTarefaPorId");
		Optional<Tarefa> tarefaPorId = tarefaMongoDBSpringRepository.findByIdTarefa(idTarefa);
		log.info("[finish] TarefaRepositoryMongoDB - buscaTarefaPorId");
		return tarefaPorId;
	}

	@Override
	public Tarefa salva(Tarefa tarefaPorId) {
		log.info("[start] TarefaRepositoryMongoDB - salva ");
		Tarefa tarefaSalva = tarefaMongoDBSpringRepository.save(tarefaPorId);
		log.info("[finish] TarefaRepositoryMongoDB - salva ");
		return tarefaSalva;
	}

}
