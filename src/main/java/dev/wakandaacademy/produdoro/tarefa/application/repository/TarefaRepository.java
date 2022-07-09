package dev.wakandaacademy.produdoro.tarefa.application.repository;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import java.util.Optional;
import java.util.UUID;

public interface TarefaRepository {
    Optional<Tarefa> buscaTarefaPorId(UUID idTarefa);

    void desativaTarefas(UUID idUsuario);

    Tarefa salva(Tarefa tarefa);

    void deleteById(Tarefa tarefaPorId);
}

