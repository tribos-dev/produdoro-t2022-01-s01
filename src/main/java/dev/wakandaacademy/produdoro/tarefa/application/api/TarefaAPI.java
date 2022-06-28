package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/tarefas")
@RestController
public interface TarefaAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	TarefaResponse adicionaTarefa (@RequestBody @Valid TarefaRequest tarefaRequest);
	@DeleteMapping("/{idTarefa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaTarefa (@PathVariable UUID idTarefa);
}