package dev.wakandaacademy.produdoro.tarefa.application.repository;
import java.util.UUID;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
public interface TarefaRepository {
	Tarefa ativaTarefa(UUID idTarefa, UUID idUsuario);
}
