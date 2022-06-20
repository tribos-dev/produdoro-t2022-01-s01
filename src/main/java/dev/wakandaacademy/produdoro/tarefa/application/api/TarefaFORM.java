package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import dev.wakandaacademy.produdoro.tarefa.domain.StatusTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TarefaFORM {
	
	@NotEmpty(message = " O campo descrição da tarefa não pode estar vazio")
	@Size(min = 3, max = 255)
	private String descricao;
	private UUID idUsuario;
	private UUID idArea;
	private UUID idProjeto;
	private StatusTarefa status;
	@Min(1)
	private int contagemPomodoro;
	
	public Tarefa toEntity() {
		return Tarefa.builder()
				.descricao(descricao)
				.idUsuario(idUsuario)
				.idArea(idArea)
				.idProjeto(idProjeto)
				.status(status)
				.contagemPomodoro(contagemPomodoro)
				.build();
	}

}
