package dev.wakandaacademy.produdoro.tarefa.infra;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface TarefaMongoDBSpringRepository extends MongoRepository<Tarefa, UUID> {
    Optional<Tarefa> findByIdTarefa(UUID idTarefa);

    void delete(Tarefa tarefaPorId);

    Optional<Tarefa> findById(UUID idTarefa);
}
