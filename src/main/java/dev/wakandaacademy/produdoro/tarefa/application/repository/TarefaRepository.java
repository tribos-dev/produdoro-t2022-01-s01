package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaRepository {
    Optional<Tarefa> buscaTarefaPorId(UUID idTarefa);

    void desativaTarefas(UUID idUsuario);

    Tarefa salva(Tarefa tarefa);

    void deleteById(Tarefa tarefaPorId);

    List<Tarefa> buscarTarefasPorIdUsuario(UUID IdUsuario);

}

