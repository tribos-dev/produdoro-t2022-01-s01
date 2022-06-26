package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/tarefas")
public interface TarefaAPI {

	@GetMapping("/{idUsuario}")
	@ResponseStatus(code = HttpStatus.OK)
	List<TarefaDTO> listaTarefasPorIdUsuario(@PathVariable UUID idUsuario);

}
