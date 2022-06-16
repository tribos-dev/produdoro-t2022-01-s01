package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/tarefa")
@RestController
public interface TarefaAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	TarefaDTO adicionaTarefa (@RequestBody @Valid TarefaFORM tarefaFORM);
}