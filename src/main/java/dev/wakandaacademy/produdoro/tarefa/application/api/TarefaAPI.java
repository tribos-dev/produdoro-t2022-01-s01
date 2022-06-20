package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface TarefaAPI {

	@PutMapping("/{idTarefa}")
	@ResponseStatus (code=HttpStatus.NO_CONTENT)
	public void editaTarefa (@PathVariable UUID idTarefa, @RequestBody @Valid TarefaFORM tarefaForm);
}
