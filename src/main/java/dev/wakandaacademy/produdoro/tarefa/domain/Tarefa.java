package dev.wakandaacademy.produdoro.tarefa.domain;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Document(collection = "Tarefa")
public class Tarefa {
	@Id
	@Builder.Default
	private UUID idTarefa = UUID.randomUUID();
	private String descricao;
	@Indexed
	private UUID idUsuario;
	@Indexed
	private UUID idArea;
	@Indexed
	private UUID idProjeto;
	@Builder.Default
	private StatusTarefa status = StatusTarefa.A_FAZER;
	@Builder.Default
	private int contagemPomodoro = 0;
}