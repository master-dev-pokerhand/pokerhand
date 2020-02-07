package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Nipe

class FullHouse extends Categoria {
    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        Map<Nipe, List<Carta>> mapaCartas = obtemCartasComMesmoValor(cartas)
        int quantidadeTrinca = mapaCartas.values().findAll { it -> it.size() == 3 }.size()
        int quantidadePares = mapaCartas.values().findAll { it -> it.size() == 2}.size()
        return quantidadeTrinca > 1 || quantidadeTrinca == 1 && quantidadePares > 0
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }
}
