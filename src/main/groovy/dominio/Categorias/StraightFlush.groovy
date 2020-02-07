package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Valor

class StraightFlush extends Sequencia {
    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        Map<Valor, List<Carta>> mapaNipe = obtemCartasComMesmoNipe(cartas)
        List<Carta> cartasFlush = mapaNipe.values().findAll { it -> it.size() == 5 }
        if(!cartasFlush.empty){
            return !getSequencia().empty
        } else {
            return false
        }
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }
}
