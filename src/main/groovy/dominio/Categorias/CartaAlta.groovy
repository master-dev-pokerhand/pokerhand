package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias

class CartaAlta extends Categoria {

	Categorias categoria_enum = Categorias.CARTA_ALTA

	@Override
	Boolean ehCategoria(List<Carta> cartas) {
		return null
	}

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		Jogador ganhador = jogadores.first()
		Carta maiorCarta = obtemMaiorCarta(ganhador.mao)
		Carta cartaAtual

		for (int idx = 1; idx <  jogadores.size(); idx++) {
			cartaAtual = obtemMaiorCarta(jogadores[idx].mao)
			if (cartaAtual.valor > maiorCarta.valor) {
				maiorCarta = cartaAtual
				ganhador = jogadores[idx]
			}
		}

		return ganhador
	}
}
