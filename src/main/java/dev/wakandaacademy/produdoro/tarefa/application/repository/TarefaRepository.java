package dev.wakandaacademy.produdoro.tarefa.application.repository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
public interface TarefaRepository {
	Tarefa ativaTarefa(String ativacao);
}
