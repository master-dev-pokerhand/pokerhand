package dominio.Categorias

import dominio.Carta
import dominio.Jogador

abstract class Categoria {
    abstract Boolean ehCategoria(List<Carta> cartas)

    abstract Jogador desempate(Jogador jogador1, Jogador jogador2)

    Carta obtemMaiorCarta(List<Carta> cartas) {
        return cartas.max { it -> it.valor.valor }
    }

	abstract Map<String, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas)

	abstract Map<String, List<Carta>> obtemCartasComMesmoNaipe(List<Carta> cartas)
}
