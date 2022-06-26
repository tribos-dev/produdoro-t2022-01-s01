package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;
import dev.wakandaacademy.produdoro.tarefa.domain.StatusTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.Getter;

@Getter
public class TarefaResponse {
	private UUID idTarefa;
	private String descricao;
	private UUID idUsuario;
	private UUID idArea;
	private UUID idProjeto;
	private StatusTarefa status;
	private int contagemPomodoro;
	
	public TarefaResponse(Tarefa tarefa) {
		this.idTarefa = tarefa.getIdTarefa();
		this.descricao = tarefa.getDescricao();
		this.idUsuario = tarefa.getIdUsuario();
		this.idArea = tarefa.getIdArea();
		this.idProjeto = tarefa.getIdProjeto();
		this.status = tarefa.getStatus();
		this.contagemPomodoro = tarefa.getContagemPomodoro();
	}
}