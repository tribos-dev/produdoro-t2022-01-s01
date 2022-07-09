package dev.wakandaacademy.produdoro.template;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import dev.wakandaacademy.produdoro.tarefa.domain.StatusTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import java.util.UUID;

import static br.com.six2six.fixturefactory.Fixture.of;

public class TarefaTemplate implements TemplateLoader {

    public static final String TAREFA_VALID_REQUEST = UUID.randomUUID().toString();
    public static final String TAREFA_VALID_RESPONSE = UUID.randomUUID().toString();
    public static final String TAREFA_INVALID_RESPONSE = UUID.randomUUID().toString();

    @Override
    public void load() {
        of(Tarefa.class)
                .addTemplate(TAREFA_VALID_REQUEST, new Rule() {
                            {
                                add("descricao", "Teste 1");
                                add("idUsuario", UUID.randomUUID());
                                add("idArea", UUID.randomUUID());
                                add("idProjeto", UUID.randomUUID());
                                add("status", StatusTarefa.A_FAZER);
                            }
                        }
                );
        of(Tarefa.class)
                .addTemplate(TAREFA_VALID_RESPONSE, new Rule() {
                            {
                                add("descricao", "Teste 1");
                                add("idUsuario", UUID.randomUUID());
                                add("idArea", UUID.randomUUID());
                                add("idProjeto", UUID.randomUUID());
                                add("status", StatusTarefa.A_FAZER);
                            }
                        }
                );
        of(Tarefa.class)
                .addTemplate(TAREFA_INVALID_RESPONSE, new Rule() {
                            {
                                add("descricao", "Teste 1");
                                add("idUsuario", UUID.randomUUID());
                                add("idArea", UUID.randomUUID());
                                add("idProjeto", UUID.randomUUID());
                                add("status", StatusTarefa.A_FAZER);
                            }
                        }
                );
    }
}
