package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public class TarefaRestController implements TarefaAPI {

	@Override
	public List<TarefaDTO> listaTarefasPorIdUsuario(UUID idUsuario) {
		List<Tarefa> listaTarefa = tarefaService.buscaTarefaPorIdUsuario(idUsuario);
		return TarefaDTO.parseListDTO(listaTarefa);
	}

}
