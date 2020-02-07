package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Valor

class Trinca extends Categoria {

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
		Map<Valor, List<Carta>> mapaValores = obtemCartasComMesmoValor(cartas)
		int quantidadeDePares = mapaValores.values().findAll { List<Carta> cartalist -> cartalist.size() == 3 }.size()

		return quantidadeDePares == 1
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }

    @Override
    Carta obtemMaiorCarta(List<Carta> mao) {
        return null
    }

}
