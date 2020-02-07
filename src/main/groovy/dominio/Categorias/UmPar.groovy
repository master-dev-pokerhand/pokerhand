package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Valor

class UmPar extends Categoria {

	Categorias categoria_enum = Categorias.UM_PAR

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
		Map<Valor, List<Carta>> mapaValores = obtemCartasComMesmoValor(cartas)
		int quantidadeDePares = mapaValores.values().findAll { List<Carta> cartalist -> cartalist.size() == 2 }.size()

		return quantidadeDePares == 1
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
		Jogador ganhador = jogadores.first()
		Integer somaPar = ganhador*.mao.flatten().sum { Carta carta -> carta.valor.valor } as Integer
		Integer somaAtual

		for (int idx = 1; idx <  jogadores.size(); idx++) {
			somaAtual = jogadores[idx]*.mao.flatten().sum { Carta carta -> carta.valor.valor } as Integer
			if (somaAtual > somaPar) {
				somaPar = somaAtual
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
