package dev.wakandaacademy.produdoro.tarefa.infra;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@AllArgsConstructor
@Repository
public class TarefaRepositoryMongoDB  implements TarefaRepository{
	
	private TarefaMongoDBSpringRepository tarefaMongoDBSpringRepository;

	@Override
	public Tarefa salva(Tarefa tarefa) {
		log.info("[start] TarefaRepositoryMongoDB - salva");
		Tarefa tarefaSalva = tarefaMongoDBSpringRepository.save(tarefa);
		log.info("[finish] TarefaRepositoryMongoDB - salva");
		return tarefaSalva;
	}

}
