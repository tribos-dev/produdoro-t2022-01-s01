package dev.wakandaacademy.produdoro.tarefa.application.service;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.handler.APIException;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@AllArgsConstructor
@Service
public class TarefaService implements TarefaApplicationService {
	private TarefaRepository tarefaRepository;

	public void ativaTarefa(UUID idTarefa, UUID idUsuario) {
		log.info("[start] TarefaSpringMongoDBService - ativaTarefa");
		tarefaRepository.desativaTarefas(idUsuario);
		Tarefa tarefaPorId = tarefaRepository.buscaTarefaPorId(idTarefa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));
		tarefaPorId.ativa();
		tarefaRepository.salva(tarefaPorId);
		log.info("[finish] TarefaSpringMongoDBService - ativaTarefa");
	}
	
	@Override
	public void salvaTarefa(@Valid Tarefa tarefa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tarefa buscaTarefaPoridTarefa(UUID idTarefa) {
		// TODO Auto-generated method stub
		return null;
	}
	
}	
