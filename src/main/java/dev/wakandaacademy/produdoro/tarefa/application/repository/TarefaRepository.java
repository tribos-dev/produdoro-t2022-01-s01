package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaRepository {

	List<Tarefa> buscarTarefaPorIdUsuario(@Valid UUID IdUsuario);
	
}
