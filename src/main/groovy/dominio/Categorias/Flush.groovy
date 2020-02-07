package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Nipe

class Flush extends Categoria {
    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        Map<Nipe, List<Carta>> mapaCartas = obtemCartasComMesmoNipe(cartas)
        return !mapaCartas.values().findAll { it -> it.size() == 5 }.empty
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }
}
