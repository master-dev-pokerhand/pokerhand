package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Valor

class Trinca extends Categoria {

    Categorias categoria_enum = Categorias.TRINCA

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
		Map<Valor, List<Carta>> mapaValores = obtemCartasComMesmoValor(cartas)
		int quantidadeDePares = mapaValores.values().findAll { List<Carta> cartalist -> cartalist.size() == 3 }.size()

		return quantidadeDePares == 1
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

    @Override
    Carta obtemMaiorCarta(List<Carta> mao) {
        return null
    }

}
