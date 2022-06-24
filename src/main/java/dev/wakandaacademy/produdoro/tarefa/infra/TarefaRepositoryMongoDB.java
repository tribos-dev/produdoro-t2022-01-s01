package dev.wakandaacademy.produdoro.tarefa.infra;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@AllArgsConstructor
@Log4j2
@Repository
public class TarefaRepositoryMongoDB  implements TarefaRepository{
    private TarefaMongoDBSpringRepository repository;
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
		Optional<Tarefa> tarefaPorId = repository.findByIdTarefa(idTarefa);
		log.info("[finish] TarefaRepositoryMongoDB - buscaTarefaPorId");
		return tarefaPorId;
	}
	@Override
	public void salva(Tarefa tarefa) {
		log.info("[start] TarefaRepositoryMongoDB - salva ");
		repository.save(tarefa);
		log.info("[finish] TarefaRepositoryMongoDB - salva ");
	}


}