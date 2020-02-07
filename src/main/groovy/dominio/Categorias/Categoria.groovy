package dominio.Categorias

import dominio.Carta
import dominio.Jogador

abstract class Categoria {
    abstract Boolean ehCategoria(List<Carta> cartas)

    abstract Jogador desempate(Jogador jogador1, Jogador jogador2)

    Carta obtemMaiorCarta(List<Carta> cartas) {
        List<Carta> cartasOrdenadas = cartas.sort() { it -> it.valor.valor }

        Carta maiorCarta = cartasOrdenadas.pop()
        if(maiorCarta.valor.valor == cartasOrdenadas.last().valor.valor)
            return null
        else
            return maiorCarta
    }

	Map<String, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas) {
        return cartas.groupBy {it -> it.valor}
    }

	Map<String, List<Carta>> obtemCartasComMesmoNaipe(List<Carta> cartas) {
        return cartas.groupBy {it -> it.nipe}
    }
}
