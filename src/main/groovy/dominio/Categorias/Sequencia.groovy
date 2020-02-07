package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class Sequencia extends Categoria {

	@Override
	Boolean ehCategoria(List<Carta> cartas) {
		return null
	}

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		return null
	}

	@Override
	Carta obtemMaiorCarta(List<Carta> mao) {
		return null
	}

}
