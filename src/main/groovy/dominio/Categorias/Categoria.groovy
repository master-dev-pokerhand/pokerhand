package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Nipe
import enuns.Valor

abstract class Categoria {
    abstract Boolean ehCategoria(List<Carta> cartas)

    abstract Jogador desempate(Jogador jogador1, Jogador jogador2)

    Carta obtemMaiorCarta(List<Carta> cartas) {
        Carta cartaMaiorValor = cartas.max { it -> it.valor.valor}
        List<Carta> repeticao = cartas.findAll { it -> it.valor.valor == cartaMaiorValor.valor.valor }
        return repeticao.size() == 1 ? cartaMaiorValor : null
    }

    Map<Valor, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas) {
        return cartas.groupBy { it -> it.valor }
    }

    Map<Nipe, List<Carta>> obtemCartasComMesmoNipe(List<Carta> cartas) {
        return cartas.groupBy { it -> it.nipe }
    }
}
