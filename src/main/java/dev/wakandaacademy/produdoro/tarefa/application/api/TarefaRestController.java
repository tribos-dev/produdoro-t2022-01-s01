package dev.wakandaacademy.produdoro.tarefa.application.api;
import org.springframework.web.bind.annotation.RestController;
import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@AllArgsConstructor
public class TarefaRestController implements TarefaAPI {
	private TarefaApplicationService tarefaService;

	@Override
	public void defineTarefaAtiva(String idTarefa) {
		log.info("[start] TarefaRestController - defineTarefaAtiva");
		tarefaService.ativaTarefa(idTarefa);
		log.info("[finish] TarefaRestController - defineTarefaAtiva");

	}

}

