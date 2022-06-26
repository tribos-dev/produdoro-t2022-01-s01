package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@Service
public interface TarefaService {

	List<Tarefa> buscarTarefaPorIdUsuario(@Valid UUID idUsuario);

}
