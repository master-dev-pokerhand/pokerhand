package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Valor

class DoisPares extends Categoria {

    Categorias categoria_enum = Categorias.DOIS_PARES

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
		Map<Valor, List<Carta>> mapaValores = obtemCartasComMesmoValor(cartas)
		int quantidadeDePares = mapaValores.values().findAll { List<Carta> cartalist -> cartalist.size() == 2 }.size()

		return quantidadeDePares == 2
    }

	@Override
	Jogador desempate(List<Jogador> jogadores) {
		Jogador ganhador = jogadores.first()
		Map<Valor, List<Carta>> mapaPares = obtemCartasComMesmoValor(ganhador.jogada.cartasDaJogada)
		Integer somaPares = (Integer) mapaPares.values().findAll { List<Carta> cartaList -> cartaList.size() == 2 }.flatten().sum { Carta carta -> carta.valor.valor }
		Integer somaAtual

		for (int idx = 1; idx <  jogadores.size(); idx++) {
			mapaPares = obtemCartasComMesmoValor(jogadores[idx].jogada.cartasDaJogada)
			somaAtual = (Integer) mapaPares.values().findAll { List<Carta> cartaList -> cartaList.size() == 2 }.flatten().sum { Carta carta -> carta.valor.valor }
			if (somaAtual > somaPares) {
				ganhador = jogadores[idx]
			}
		}

		return ganhador
	}

}
