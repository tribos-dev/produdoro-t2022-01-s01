package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping
public interface TarefaAPI {

	@GetMapping("/{idTarefa}/tarefas")
	@ResponseStatus(code = HttpStatus.OK)
	List<TarefaDTO> listaTarefasPorIdUsuario(@Valid @PathVariable UUID idTarefa);

}
