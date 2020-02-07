package enuns

enum Categorias {

	ROYAL_FLUSH(10),
	STRAIGHT_FLUSH(9),
	QUADRA(8),
	FULL_HOUSE(7),
	FLUSH(6),
	SEQUENCIA(5),
	TRINCA(4),
	DOIS_PARES(3),
	UM_PAR(2),
	CARTA_ALTA(1)

	Categorias(int value) {
		this.categoria = value
	}

	private final int categoria

	int getCategoria() {
		categoria
	}
}