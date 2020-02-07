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
		Integer somaPares = ganhador*.jogada.cartasDaJogada.flatten().sum { Carta carta -> carta.valor.valor } as Integer
		Integer somaAtual

		for (int idx = 1; idx <  jogadores.size(); idx++) {
			somaAtual = jogadores[idx]*.jogada.cartasDaJogada.flatten().sum { Carta carta -> carta.valor.valor } as Integer
			if (somaAtual > somaPares) {
				somaPares = somaAtual
				ganhador = jogadores[idx]
			}
		}

		return ganhador
    }

}
