package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class Sequencia extends Categoria {

	@Override
	Boolean ehCategoria(List<Carta> cartas) {

		cartas.sort { Carta carta -> carta.valor.valor }
		List<Carta> cartasUnicas = cartas.unique(false,{Carta carta -> carta.valor.valor})
		List<Carta> sequencia = getSequencia(cartasUnicas)
		return sequencia

	}

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		Jogador vencedor = jogadores[0]
		Carta maiorCartaJogador = obtemMaiorCarta(vencedor.jogada.cartasDaJogada)
		Carta maiorCartaTodas = maiorCartaJogador

		for(int idx = 1; idx <  jogadores.size(); idx++){
			Jogador jogadorAtual = jogadores[idx]
			Carta maiorCartaAtual = obtemMaiorCarta(jogadorAtual.jogada.cartasDaJogada)

			if(maiorCartaAtual.valor > maiorCartaJogador.valor){
				vencedor = jogadorAtual
				maiorCartaTodas = maiorCartaAtual
			}
		}

		List<Jogador> jogadoresSemOVencedor = jogadores - vencedor

		Boolean existeEmpate = jogadoresSemOVencedor.any{Jogador jogador ->
			return jogador.jogada.cartasDaJogada.find{Carta carta ->
				carta.valor == maiorCartaTodas.valor
			}
		}

		return existeEmpate ? null : vencedor
	}

	List<Carta> getSequencia(List<Carta> cartasOrdenadasValorUnico){
		List<Carta> sequencia = []

		for (int i = 0; i < cartasOrdenadasValorUnico.size(); i++) {
			Carta proximaCarta = cartasOrdenadasValorUnico[i+1]
			if (proximaCarta && cartasOrdenadasValorUnico[i].valor.valor + 1 != proximaCarta.valor.valor) {
				sequencia = []
			}
			sequencia.add(cartasOrdenadasValorUnico[i])
		}

		if(sequencia.size() < 5) {
			return []
		}

		return sequencia
	}
}
