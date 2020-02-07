package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class Sequencia extends Categoria {

	@Override
	Boolean ehCategoria(List<Carta> cartas) {

		cartas.sort { Carta carta -> carta.valor.valor }

		List<Integer> valoresList = cartas*.valor.valor.unique()

		for (int i = 0; i < valoresList.size() - 1; i++) {
			if (valoresList[i] + 1 != valoresList[i + 1]) {
				return false
			}
		}

		if (valoresList.size() < 5) {
			return false
		}

		return true
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
