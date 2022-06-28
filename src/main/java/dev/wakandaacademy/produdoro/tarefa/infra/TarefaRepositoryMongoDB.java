package dev.wakandaacademy.produdoro.tarefa.infra;

import org.springframework.stereotype.Repository;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@AllArgsConstructor
@Repository
public class TarefaRepositoryMongoDB  implements TarefaRepository{
	private TarefaMongoDBSpringRepository tarefaMongoDBSpringRepository;

	@Override
	public Tarefa salva(Tarefa tarefa) {
		log.info("[inicia] TarefaRepositoryMongoDB - salva");
		Tarefa tarefaSalva = tarefaMongoDBSpringRepository.save(tarefa);
		log.info("[finaliza] TarefaRepositoryMongoDB - salva");
		return tarefaSalva;
	}
	@Override
	public Optional<Tarefa> buscaTarefaPorId(UUID idTarefa) {
		log.info("[start] TarefaRepositoryMongoDB - buscaTarefaPorId");
		Optional<Tarefa> tarefaPorId = tarefaMongoDBSpringRepository.findByIdTarefa(idTarefa);
		log.info("[finish] TarefaRepositoryMongoDB - buscaTarefaPorId");
		return tarefaPorId;
	}
	@Override
	public void deleteById(Tarefa tarefaPorId) {
		tarefaMongoDBSpringRepository.delete(tarefaPorId);
	}
}