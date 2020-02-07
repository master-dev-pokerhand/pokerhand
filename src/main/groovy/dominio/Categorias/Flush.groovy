package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Nipe

class Flush extends Categoria {

	Categorias categoria_enum = Categorias.FLUSH

	@Override
	Boolean ehCategoria(List<Carta> cartas) {
		Map<Nipe, List<Carta>> mapaCartas = obtemCartasComMesmoNipe(cartas)
		return !mapaCartas.values().findAll { it -> it.size() == 5 }.empty
	}

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		Jogador ganhador = jogadores.first()
		Map<Nipe, List<Carta>> mapaFlush = obtemCartasComMesmoNipe(ganhador.jogada.cartasDaJogada)
		List<Carta> cartasDoFlush = mapaFlush.find { Map.Entry<Nipe, List<Carta>> flushes ->
			return flushes.value.size() >= 5
		}.value

		Carta maiorCartaFlush = obtemMaiorCarta(cartasDoFlush)
		Carta maiorCartaTodas = maiorCartaFlush

		for(int idx = 1; idx <  jogadores.size(); idx++){
			Jogador jogadorAtual = jogadores[idx]
			Map<Nipe, List<Carta>> mapaFlushJogadorAtual = obtemCartasComMesmoNipe(jogadorAtual.jogada.cartasDaJogada)

			List<Carta> cartasDoFlushJogadorAtual = mapaFlushJogadorAtual.find { Map.Entry<Nipe, List<Carta>> flushes ->
				return flushes.value.size() >= 5
			}.value

			Carta maiorCartaFlushJogadorAtual = obtemMaiorCarta(cartasDoFlushJogadorAtual)

			if(maiorCartaFlushJogadorAtual.valor.valor > maiorCartaFlush.valor.valor){
				ganhador = jogadorAtual
				maiorCartaTodas = maiorCartaFlushJogadorAtual
			}
		}

		List<Jogador> jogadoresSemOVencedor = jogadores - ganhador

		Boolean existeEmpate = jogadoresSemOVencedor.any{Jogador jogador ->
			return jogador.jogada.cartasDaJogada.find{Carta carta ->
				carta.valor == maiorCartaTodas.valor
			}
		}

		return existeEmpate ? null : ganhador
	}
}
