package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Getter
@Setter
@Log4j2
@Service
public class TarefaSpringMongoDBService implements TarefaService {
	private TarefaRepository tarefaRepository;

	@Override
	public List<Tarefa> buscaTarefaPorIdUsuario(UUID idUsuario) {
		log.info("[start] TarefaSpringMongoDBService - buscaTodasAsTarefasPorIdUsuario");
		List<Tarefa> listaDeTarefa = tarefaRepository.buscaTarefaPorIdUsuario(idUsuario);
		log.info("[finish] TarefaSpringMongoDBService - buscaTodasAsTarefasPorIdUsuario");
		return listaDeTarefa;
	}
}
