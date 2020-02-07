package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Valor

class StraightFlush extends Sequencia {

    Categorias categoria_enum = Categorias.STRAIGHT_FLUSH

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
