package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@Repository
public interface TarefaMongoDBSpringRepository extends MongoRepository<Tarefa, UUID>{

	Tarefa buscaTarefaPorIdTarefa(UUID idTarefa);

	Optional<Tarefa> findByIdTarefa(UUID idTarefa);
}
