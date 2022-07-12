package dev.wakandaacademy.produdoro.tarefa.application.service;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.handler.APIException;
import dev.wakandaacademy.produdoro.handler.FalhaAoProcessarSalvaTarefaExecption;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

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

    @Override
    public List<Tarefa> buscarTarefasPorIdUsuario(UUID idUsuario) {
        log.info("[start] TarefaSpringMongoDBService - buscarTodasAsTarefasPorIdUsuario");
        List<Tarefa> listaDeTarefa = tarefaRepository.buscarTarefasPorIdUsuario(idUsuario);
        log.info("[finish] TarefaSpringMongoDBService - buscarTodasAsTarefasPorIdUsuario");
        return listaDeTarefa;
    }
}