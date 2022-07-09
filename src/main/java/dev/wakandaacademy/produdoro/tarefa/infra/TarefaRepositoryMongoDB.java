package dev.wakandaacademy.produdoro.tarefa.infra;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@AllArgsConstructor
@Repository
public class TarefaRepositoryMongoDB  implements TarefaRepository{
    private TarefaMongoDBSpringRepository tarefaMongoDBSpringRepository;
    private MongoTemplate mongoTemplate;

	@Override
	public void desativaTarefas(UUID idUsuario) {
		log.info("[start] TarefaRepositoryMongoDB - desativaTarefas");
		Query query = new Query();
		query.addCriteria(Criteria.where("idUsuario").is(idUsuario));

		Update update = new Update();
		update.set("statusAtivacao", "INATIVA");
		mongoTemplate.updateMulti(query, update, Tarefa.class);
		log.info("[finish] TarefaRepositoryMongoDB - desativaTarefas");
	}

	@Override
	public Optional<Tarefa> buscaTarefaPorId(UUID idTarefa) {
		log.info("[start] TarefaRepositoryMongoDB - buscaTarefaPorId");
		Optional<Tarefa> tarefaPorId = tarefaMongoDBSpringRepository.findByIdTarefa(idTarefa);
		log.info("[finish] TarefaRepositoryMongoDB - buscaTarefaPorId");
		return tarefaPorId;
	}

	@Override
	public Tarefa salva(Tarefa tarefa) {
		log.info("[inicia] TarefaRepositoryMongoDB - salva");
		Tarefa tarefaSalva = tarefaMongoDBSpringRepository.save(tarefa);
		log.info("[finaliza] TarefaRepositoryMongoDB - salva");
		return tarefaSalva;
	}

	@Override
	public void deleteById(Tarefa tarefaPorId) {
		tarefaMongoDBSpringRepository.delete(tarefaPorId);
	}
}