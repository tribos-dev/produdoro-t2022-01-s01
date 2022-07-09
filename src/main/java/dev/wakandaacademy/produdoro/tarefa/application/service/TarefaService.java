package dev.wakandaacademy.produdoro.tarefa.application.service;
import dev.wakandaacademy.produdoro.handler.FalhaAoProcessarSalvaTarefaExecption;

import dev.wakandaacademy.produdoro.handler.APIException;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@AllArgsConstructor
@Service
public class TarefaService implements TarefaApplicationService {

    private TarefaRepository tarefaRepository;

    public void ativaTarefa(UUID idUsuario, UUID idTarefa) {
        log.info("[start] TarefaService - ativaTarefa");
        tarefaRepository.desativaTarefas(idUsuario);
        Tarefa tarefaPorId = tarefaRepository.buscaTarefaPorId(idTarefa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));
        tarefaPorId.ativa();
        tarefaRepository.salva(tarefaPorId);
        log.info("[finish] TarefaService - ativaTarefa");
    }

    @Override
    public Tarefa buscaTarefaPoridTarefa(UUID idTarefa) {
        log.info("[start] TarefaService - buscaTarefaPoridTarefa");
        Tarefa buscaTarefa = tarefaRepository.buscaTarefaPorId(idTarefa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));
        log.info("[finish] TarefaService - buscaTarefaPoridTarefa");
        return buscaTarefa;
    }

    @SneakyThrows
    public Tarefa adicionaTarefa(Tarefa tarefa) {
        log.info("[inicia] TarefaService - adicionaTarefa");
        Tarefa salvaTarefa;

        try {
            tarefa.setContagemPomodoro(tarefa.getStatus().tempoPomodoro());
            salvaTarefa = tarefaRepository.salva(tarefa);
        } catch (FalhaAoProcessarSalvaTarefaExecption e) {
            throw new FalhaAoProcessarSalvaTarefaExecption();
        }

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
    public Tarefa detalhaTarefa(UUID idTarefa) {
        log.info("[inicia] TarefaService - detalhaTarefa");
        Tarefa tarefa =
                tarefaRepository.buscaTarefaPorId(idTarefa)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Tarefa não encontrada!"));;
        log.info("[finaliza] TarefaService - detalhaTarefa");
        return tarefa;
    }
}