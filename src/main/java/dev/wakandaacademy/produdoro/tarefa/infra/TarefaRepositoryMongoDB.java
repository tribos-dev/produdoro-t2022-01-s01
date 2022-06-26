package dev.wakandaacademy.produdoro.tarefa.infra;

import org.springframework.stereotype.Repository;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
}