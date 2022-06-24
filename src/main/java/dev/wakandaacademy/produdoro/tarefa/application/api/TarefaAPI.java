package dev.wakandaacademy.produdoro.tarefa.application.api;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
@RequestMapping("/tarefas")
public interface TarefaAPI {
	@PatchMapping("/{idTarefa}/status")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void defineTarefaAtiva(@PathVariable UUID idTarefa, @RequestParam UUID idUsuario);
	
}
