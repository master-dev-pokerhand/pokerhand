package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class RoyalFlush implements Categoria{

	@Override
	Boolean ehCategoria(List<Carta> cartas) {
		return null
	}

	@Override
	Jogador desempate(Jogador jogador1, Jogador jogador2) {
		return null
	}

	@Override
	Carta obtemMaiorCarta(List<Carta> mao) {
		return null
	}
}
