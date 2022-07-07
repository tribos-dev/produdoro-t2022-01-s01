package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaResponse;
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
	public Tarefa editaTarefa(UUID idTarefa, TarefaRequest tarefaRequest) {
		log.info("[start] TarefaService - editaTarefa");
		Tarefa tarefaAtualizado = tarefaRepository.buscaTarefaPorId(idTarefa);
		UUID id = tarefaAtualizado.getIdTarefa();
		
		tarefaAtualizado.setIdTarefa(id);
		tarefaAtualizado.setDescricao(tarefaRequest.getDescricao());
		tarefaAtualizado.setIdArea(tarefaRequest.getIdArea());
		tarefaAtualizado.setIdProjeto(tarefaRequest.getIdProjeto());
		tarefaAtualizado.setIdUsuario(tarefaRequest.getIdUsuario());
		tarefaAtualizado.setStatus(tarefaRequest.getStatus());
		tarefaAtualizado.setContagemPomodoro(tarefaRequest.getContagemPomodoro());
		Tarefa tarefa = tarefaRepository.salva(tarefaAtualizado);
		log.info("[finish] TarefaService - editaTarefa");
		return tarefa;
	}
	
//	@Override
//	public ClientResponseDTO updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO, String cpf) {
//		Client clientByCpf = clientRepositoryAPI.findByCpf(cpf)
//				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "client not found"));
//		Long clientId = clientByCpf.getId();
//		clientByCpf.setId(clientId);
//		clientByCpf.setName(clientUpdateRequestDTO.getName());
//		clientByCpf.setBirthday(clientUpdateRequestDTO.getBirthday());
//		clientByCpf.setMaritalStatus(clientUpdateRequestDTO
//
}
