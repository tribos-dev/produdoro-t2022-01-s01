package dev.wakandaacademy.produdoro.tarefa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/v1/tarefas")
public interface TarefaAPI {

    @PostMapping("/tarefa/{idTarefa}/ativacao")
    @ResponseStatus(code = HttpStatus.CREATED)
    void defineTarefaAtiva(@RequestParam UUID idUsuario, @PathVariable UUID idTarefa);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaResponse adicionaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);

    @DeleteMapping("/{idTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaTarefa(@PathVariable UUID idTarefa);

	@GetMapping("/{idTarefa}")
	@ResponseStatus(code = HttpStatus.OK)
	TarefaResponse detalhaTarefa(@PathVariable UUID idTarefa);
}