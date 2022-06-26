package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class TarefaRestController implements TarefaAPI {
	private TarefaService tarefaService;

	@Override
	public List<TarefaDTO> listaTarefasPorIdUsuario(UUID idUsuario) {
		log.info("[start] TarefaRestController - listaTarefasPorIdUsuario");
		List<Tarefa> listaTarefa = tarefaService.buscaTarefaPorIdUsuario(idUsuario);
		log.info("[finish] TarefaRestController - listaTarefasPorIdUsuario");
		return TarefaDTO.parseListDTO(listaTarefa);
	}
}
