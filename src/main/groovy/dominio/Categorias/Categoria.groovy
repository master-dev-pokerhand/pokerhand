package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Nipe
import enuns.Valor

abstract class Categoria {
    abstract Categorias categoria_enum
    abstract Boolean ehCategoria(List<Carta> cartas)

    abstract Jogador desempate(List<Jogador> jogadores)

    Carta obtemMaiorCarta(List<Carta> cartas) {
        return cartas.max { it -> it.valor.valor}
    }

    Map<Valor, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas) {
        return cartas.groupBy { it -> it.valor }
    }

    Map<Nipe, List<Carta>> obtemCartasComMesmoNipe(List<Carta> cartas) {
        return cartas.groupBy { it -> it.nipe }
    }
}
