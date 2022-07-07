package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/v1/tarefas")
@RestController
public interface TarefaAPI {

	@PutMapping("/{idTarefa}")
	@ResponseStatus (code=HttpStatus.NO_CONTENT)
	TarefaResponse editaTarefa (@PathVariable UUID idTarefa, @RequestBody @Valid TarefaRequest tarefaRequest);

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	TarefaResponse adicionaTarefa (@RequestBody @Valid TarefaRequest tarefaRequest);
}
