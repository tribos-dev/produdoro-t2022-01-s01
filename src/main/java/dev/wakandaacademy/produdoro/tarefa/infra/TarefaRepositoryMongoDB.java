package dev.wakandaacademy.produdoro.tarefa.infra;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@AllArgsConstructor
@Log4j2
@Repository
public class TarefaRepositoryMongoDB  implements TarefaRepository{
    private TarefaMongoDBSpringRepository repository;
	@Override
	public Tarefa ativaTarefa(UUID idTarefa, UUID idUsuario) {
		log.info("[start] TarefaRepositoryMongoDB - ativaTarefa");
		log.info("[finish] TarefaRepositoryMongoDB - ativaTarefa");
	
		return null;
	}

}