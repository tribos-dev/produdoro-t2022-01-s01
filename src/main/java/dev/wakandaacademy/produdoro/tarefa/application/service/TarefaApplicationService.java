package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import javax.validation.Valid;
import java.util.UUID;

public interface TarefaApplicationService {
    void ativaTarefa(@Valid UUID idUsuario, @Valid UUID idTarefa);

    Tarefa buscaTarefaPoridTarefa(@Valid UUID idTarefa);

    void deletaTarefa(UUID idTarefa);

    Tarefa adicionaTarefa(Tarefa tarefa);

    Tarefa detalhaTarefa(UUID idTarefa);
}

