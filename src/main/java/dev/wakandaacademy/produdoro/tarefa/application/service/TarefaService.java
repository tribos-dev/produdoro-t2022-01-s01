package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public class TarefaService implements TarefaApplicationService {

	List<Tarefa> buscaTarefaPorIdUsuario(@Valid UUID idUsuario);

}
