package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaApplicationService {
    void ativaTarefa(UUID idUsuario, UUID idTarefa);

    void deletaTarefa(UUID idTarefa);

    Tarefa adicionaTarefa(Tarefa tarefa);

    Tarefa detalhaTarefa(UUID idTarefa);

    List<Tarefa> buscarTarefasPorIdUsuario(UUID idUsuario);
}

