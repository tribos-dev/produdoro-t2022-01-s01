package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.handler.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Log4j2
@AllArgsConstructor
@Service
public class TarefaService implements TarefaApplicationService {
	private TarefaRepository tarefaRepository;

	public Tarefa adicionaTarefa(Tarefa tarefa) {
		log.info("[inicia] TarefaService - adicionaTarefa");
		Tarefa salvaTarefa = tarefaRepository.salva(tarefa);
		log.info("[finaliza] TarefaService - adicionaTarefa");
		return salvaTarefa;
	}
	@Override
	public void deletaTarefa(UUID idTarefa) {
		log.info("[start] TarefaSpringMongoDBService - deleTarefa");
		Tarefa tarefaPorId = tarefaRepository.buscaTarefaPorId(idTarefa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));
		tarefaRepository.deleteById(tarefaPorId);
		log.info("[finish] TarefaSpringMongoDBService - deletaTarefa");
	}
	@Override
	public Tarefa buscaTarefaPoridTarefa(UUID idTarefa) {
		log.info("[start] TarefaSpringMongoDBService - buscaTodasAsTarefasPoridTarefa");
		Tarefa buscaTarefa = tarefaRepository.buscaTarefaPorId(idTarefa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));
		log.info("[finish] TarefaSpringMongoDBService - buscaTodasAsTarefasPoridTarefa");
		return buscaTarefa;
	}
}