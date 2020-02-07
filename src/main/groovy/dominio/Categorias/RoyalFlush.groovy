package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class RoyalFlush extends Categoria {

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        return null
    }

    @Override
    Jogador desempate(Jogador jogador1, Jogador jogador2) {
        return null
    }

	Map<String, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas) {
		return ['A': []]
	}

	Map<String, List<Carta>> obtemCartasComMesmoNaipe(List<Carta> cartas) {
		return ['A': []]
	}
}
