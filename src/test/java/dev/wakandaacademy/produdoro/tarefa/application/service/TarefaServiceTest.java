package dev.wakandaacademy.produdoro.tarefa.application.service;

import br.com.six2six.fixturefactory.Fixture;
import dev.wakandaacademy.produdoro.handler.FalhaAoProcessarSalvaTarefaExecption;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.StatusTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.template.Templates;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static dev.wakandaacademy.produdoro.template.TarefaTemplate.TAREFA_VALID_REQUEST;
import static dev.wakandaacademy.produdoro.template.TarefaTemplate.TAREFA_VALID_RESPONSE;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TarefaServiceTest {

    @InjectMocks
    private TarefaService classe;

    @Mock
    private TarefaRepository tarefaRepository;

    @BeforeClass
    public static void before() {
        loadTemplates(Templates.BASE_PACKAGE);
    }

    @Test
    public void verificarSeRealmenteSalvaTest() {

        //DADO - GIVEN
        Tarefa tarefaRequest = Fixture.from(Tarefa.class).gimme(TAREFA_VALID_REQUEST);
        Tarefa tarefaResponse = Fixture.from(Tarefa.class).gimme(TAREFA_VALID_RESPONSE);

        //QUANDO - WHEN
        when(tarefaRepository.salva(tarefaRequest))
                .thenReturn(tarefaResponse);
        classe.adicionaTarefa(tarefaRequest);

        //ENTAO - THEN
        //Eu quero que seja obrigatorio a chamada do metodo salva
        verify(tarefaRepository, times(1)).salva(any());
    }

    @Test
    public void verificarSeTemConteudoTest() {

        //DADO - GIVEN
        Tarefa tarefaRequest = new Tarefa();
        tarefaRequest.setDescricao("Testes unitario");
        Tarefa tarefaResponse = new Tarefa();
        tarefaResponse.setDescricao("Testes unitario");

        //QUANDO - WHEN
        when(tarefaRepository.salva(tarefaRequest))
                .thenReturn(tarefaResponse);
        classe.adicionaTarefa(tarefaRequest);

        //ENTAO - THEN
        //Eu quero validar o retorno do descricao
        assertEquals(tarefaRequest.getDescricao(),
                tarefaResponse.getDescricao());
    }


    @Test(expected = FalhaAoProcessarSalvaTarefaExecption.class)
    public void verificarSeDeuErroTest() {

        //DADO - GIVEN
        Tarefa tarefaRequest = Tarefa.builder().descricao("Testes unitario").build(); //Mocks
        Tarefa tarefaResponse = new Tarefa(); //Mocks
        tarefaResponse.setDescricao("Testes unitario");

        //QUANDO - WHEN
        doThrow(FalhaAoProcessarSalvaTarefaExecption.class)
                .when(tarefaRepository).salva(tarefaRequest);
        classe.adicionaTarefa(tarefaRequest);

        //ENTAO - THEN
        //Eu quero que seja obrigatorio a chamada do metodo salva
        verify(tarefaRepository, times(1)).salva(any());
    }


    //TDD TESTE 1 -Requisito: Se a tarefa esta com status "A_FAZER" o pomodoro deve ser de 10 min
    @Test
    public void pomodoroAFazerTest() {
        Tarefa tarefaRequest = new Tarefa();
        tarefaRequest.setDescricao("Testes unitario");
        tarefaRequest.setStatus(StatusTarefa.A_FAZER);

        when(tarefaRepository.salva(tarefaRequest))
                .thenReturn(tarefaRequest);
        Tarefa response = classe.adicionaTarefa(tarefaRequest);
        assertEquals(10,
                response.getContagemPomodoro());
    }

    //TDD TESTE 2 - Requisito: Se a tarefa esta com status "CONCLUIDA"
    // o pomodoro deve ser de 20 min

    @Test
    public void pomodoroCONCLUIDATest() {

        Tarefa tarefaRequest = new Tarefa();
        tarefaRequest.setDescricao("Testes unitario");
        tarefaRequest.setStatus(StatusTarefa.CONCLUIDA);

        when(tarefaRepository.salva(tarefaRequest))
                .thenReturn(tarefaRequest);
        Tarefa response = classe.adicionaTarefa(tarefaRequest);
        assertEquals(20,
                response.getContagemPomodoro());
    }

    //
}