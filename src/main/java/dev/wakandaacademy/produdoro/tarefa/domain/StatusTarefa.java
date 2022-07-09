package dev.wakandaacademy.produdoro.tarefa.domain;
public enum StatusTarefa {
	A_FAZER {
		@Override
		public int tempoPomodoro() {
			return 10;
		}
	},
	CONCLUIDA {
		@Override
		public int tempoPomodoro() {
			return 20;
		}
	};

	public abstract int tempoPomodoro();
}