package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.StatusTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.Setter;

@Setter
public class TarefaFORM {
	
	private String descricao;
	private UUID idUsuario;
	private UUID idArea;
	private UUID idProjeto;
	private StatusTarefa status;

	public Tarefa toEntity() {
		return Tarefa.builder()
				.descricao(descricao)
				.idUsuario(idUsuario)
				.idArea(idArea)
				.idProjeto(idProjeto)
				.status(status)
				.build();
	}

}
