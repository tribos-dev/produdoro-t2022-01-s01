package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

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

	public Tarefa adicionaTarefa(Tarefa tarefa) {
		log.info("[inicia] TarefaService - adicionaTarefa");
		Tarefa salvaTarefa = tarefaRepository.salva(tarefa);
		log.info("[finaliza] TarefaService - adicionaTarefa");
		return salvaTarefa;
	}

	@Override
	public Tarefa detalhaTarefa(UUID idTarefa) {
		log.info("[inicia] TarefaService - detalhaTarefa");
		Tarefa tarefa = tarefaRepository.buscaTarefaPorIdTarefa(idTarefa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));
		log.info("[finaliza] TarefaService - detalhaTarefa");
		return tarefa;
	}
}