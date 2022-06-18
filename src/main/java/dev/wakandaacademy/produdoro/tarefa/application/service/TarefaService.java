package dev.wakandaacademy.produdoro.tarefa.application.service;
import org.springframework.stereotype.Service;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@AllArgsConstructor
@Service
public class TarefaService implements TarefaApplicationService {
	private TarefaRepository tarefaRepository;

	@Override
	public Tarefa ativaTarefa(String ativacao) {
		log.info("[start] TarefaService - ativaTarefa");
		Tarefa tarefa = tarefaRepository.ativaTarefa(ativacao);
		log.info("[finish] TarefaService - ativaTarefa");
		return tarefa;
	}


}	
