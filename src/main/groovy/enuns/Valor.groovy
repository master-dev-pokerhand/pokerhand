package enuns

enum Valor {
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9),
	DEZ(10),
	VALETE(11),
	DAMA(12),
	REI(13),
	AS(14)

	Valor(int value) {
		this.valor = value
	}
	private final int valor

	int getValor() {
		valor
	}

	public String toString() {
		return name() + " = " + valor
	}
}