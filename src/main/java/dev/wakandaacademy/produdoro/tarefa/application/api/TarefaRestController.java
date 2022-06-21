package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@RestController
@Log4j2
public class TarefaRestController implements TarefaAPI {
	
	@Autowired
	private TarefaService tarefaService;

	@Override
	public void editaTarefa(UUID idTarefa, @Valid TarefaFORM tarefaForm) {
		log.info("[Start] TarefaRestController - editaTarefa");
		tarefaService.editaTarefa(idTarefa, tarefaForm.toEntity());
		log.info("[Finish] TarefaRestController - editaTarefa");
	}

}
