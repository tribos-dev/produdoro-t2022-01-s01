package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaMongoDBSpringRepository extends MongoRepository<Tarefa, UUID> {

	List<Tarefa> findAllByIdUsuario(@Valid UUID idUsuario);
}
