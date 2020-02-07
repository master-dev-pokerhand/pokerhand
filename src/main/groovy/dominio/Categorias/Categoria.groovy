package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Nipe
import enuns.Valor

abstract class Categoria {
    abstract Boolean ehCategoria(List<Carta> cartas)

    abstract Jogador desempate(List<Jogador> jogadores)

    Carta obtemMaiorCarta(List<Carta> cartas) {
        Carta cartaMaiorValor = cartas.max { it -> it.valor.valor}
        return cartaMaiorValor
    }

    Map<Valor, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas) {
        return cartas.groupBy { it -> it.valor }
    }

    Map<Nipe, List<Carta>> obtemCartasComMesmoNipe(List<Carta> cartas) {
        return cartas.groupBy { it -> it.nipe }
    }
}
