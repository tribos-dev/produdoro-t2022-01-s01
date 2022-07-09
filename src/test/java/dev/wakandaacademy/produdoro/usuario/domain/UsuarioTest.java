package dev.wakandaacademy.produdoro.usuario.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.wakandaacademy.produdoro.pomodoro.domain.ConfiguracaoPadrao;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioNovoRequest;

class UsuarioTest {

	@Test
	void testUsuario() {
		String email = "vini@email.com";
		UsuarioNovoRequest requestNovoUsuario = new UsuarioNovoRequest(email, "123456");
		ConfiguracaoPadrao configuracaoPadrao = ConfiguracaoPadrao.builder()
				.codigo("DEFAULT")
				.tempoMinutosFoco(25)
				.tempoMinutosPausaCurta(5)
				.tempoMinutosPausaLonga(30)
				.repeticoesParaPausaLonga(4)
				.build();

		
		var usuario = new Usuario(requestNovoUsuario, configuracaoPadrao);
		
		
		
		assertEquals(usuario.getEmail(), email);
	}
}
