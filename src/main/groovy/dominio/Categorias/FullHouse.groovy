package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Nipe
import enuns.Valor

class FullHouse extends Categoria {

	Categorias categoria_enum = Categorias.FULL_HOUSE

	@Override
	Boolean ehCategoria(List<Carta> cartas) {
		Map<Nipe, List<Carta>> mapaCartas = obtemCartasComMesmoValor(cartas)
		int quantidadeTrinca = mapaCartas.values().findAll { it -> it.size() == 3 }.size()
		int quantidadePares = mapaCartas.values().findAll { it -> it.size() == 2 }.size()
		return quantidadeTrinca > 1 || quantidadeTrinca == 1 && quantidadePares > 0
	}

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		Jogador ganhador = jogadores.first()
		Map<Valor, List<Carta>> mapaTrinca = obtemCartasComMesmoValor(ganhador.jogada.cartasDaJogada)
		Integer somaTrinca = (Integer) mapaTrinca.values().findAll { List<Carta> cartaList -> cartaList.size() == 3 }.flatten().sum { Carta carta -> carta.valor.valor }
		Integer somaAtual

		for (int idx = 1; idx <  jogadores.size(); idx++) {
			mapaTrinca = obtemCartasComMesmoValor(jogadores[idx].jogada.cartasDaJogada)
			somaAtual = (Integer) mapaTrinca.values().findAll { List<Carta> cartaList -> cartaList.size() == 3 }.flatten().sum { Carta carta -> carta.valor.valor }
			if (somaAtual > somaTrinca) {
				ganhador = jogadores[idx]
			}
		}

		return ganhador
	}
}
