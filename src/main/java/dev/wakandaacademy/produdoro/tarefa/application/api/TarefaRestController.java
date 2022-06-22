package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TarefaRestController implements TarefaAPI {
	private TarefaService tarefaService;

	@Override
	public List<TarefaDTO> listaTarefasPorIdUsuario(UUID idUsuario) {
		List<Tarefa> listaTarefa = TarefaService.buscaTarefaPorIdUsuario(idUsuario);
		return TarefaDTO.parseListDTO(listaTarefa);
	}
}
