package dev.wakandaacademy.produdoro.tarefa.infra;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TarefaMongoDBSpringRepository extends MongoRepository<Tarefa, UUID> {
    Optional<Tarefa> findByIdTarefa(UUID idTarefa);

    void delete(Tarefa tarefaPorId);

    Optional<Tarefa> findById(UUID idTarefa);

    List<Tarefa> findAllByIdUsuario(UUID idUsuario);

}
