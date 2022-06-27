package dev.wakandaacademy.produdoro.tarefa.application.api;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
@RequestMapping("/v1/tarefas")
public interface TarefaAPI {
	@PostMapping("/tarefa/{idTarefa}/ativacao")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void defineTarefaAtiva(@PathVariable UUID idTarefa, @RequestParam UUID idUsuario);
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	TarefaResponse adicionaTarefa (@RequestBody @Valid TarefaRequest tarefaRequest);
}

