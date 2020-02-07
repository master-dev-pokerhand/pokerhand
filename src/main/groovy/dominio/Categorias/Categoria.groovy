package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Nipe
import enuns.Valor

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

	Map<Valor, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas) {
        return cartas.groupBy {it -> it.valor}
    }

	Map<Nipe, List<Carta>> obtemCartasComMesmoNipe(List<Carta> cartas) {
        return cartas.groupBy {it -> it.nipe}
    }
}
