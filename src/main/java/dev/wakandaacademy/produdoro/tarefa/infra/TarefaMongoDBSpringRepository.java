package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaMongoDBSpringRepository extends MongoRepository<Tarefa, UUID>{
	
	Optional<Tarefa> findByIdTarefa(UUID idTarefa);

}
