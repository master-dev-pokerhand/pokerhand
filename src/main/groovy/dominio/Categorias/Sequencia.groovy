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
		Jogador vencedor = jogadores[0]
		Carta maiorCartaJogador = obtemMaiorCarta(vencedor.jogada.cartasDaJogada)

		for(int idx =1; idx <  jogadores.size(); idx++){
			Jogador jogadorAtual = jogadores[idx]
			Carta maiorCartaAtual = obtemMaiorCarta(jogadorAtual.jogada.cartasDaJogada)

			if(maiorCartaAtual.valor > maiorCartaJogador.valor){
				vencedor = jogadorAtual
			}
		}

		return vencedor
	}

}
