package dev.wakandaacademy.produdoro.tarefa.application.repository;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TarefaRepository {
    Optional<Tarefa> buscaTarefaPorId(UUID idTarefa);

    void desativaTarefas(UUID idUsuario);

    Tarefa salva(Tarefa tarefa);

    void deleteById(Tarefa tarefaPorId);

    List<Tarefa> buscarTarefasPorIdUsuario(@Valid UUID IdUsuario);

}

