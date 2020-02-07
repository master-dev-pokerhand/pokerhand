package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class CartaAlta extends Categoria {

	@Override
	Boolean ehCategoria(List<Carta> cartas) {
		return null
	}

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		Jogador ganhador = jogadores.first()
		Carta maiorCarta = obtemMaiorCarta(ganhador.mao)
		Carta cartaAtual

		for (Jogador jogador in jogadores) {
			cartaAtual = obtemMaiorCarta(jogador.mao)
			if (cartaAtual.valor > maiorCarta.valor) {
				maiorCarta = cartaAtual
				ganhador = jogador
			}
		}

		return ganhador
	}
}
