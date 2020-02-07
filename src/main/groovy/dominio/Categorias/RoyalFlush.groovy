package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Valor

class RoyalFlush extends StraightFlush {

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        if(super.ehCategoria(cartas)){
            List<Carta> sequencia = getStraightFlush(cartas)
            sequencia.sort { it -> it.valor.valor}
            return sequencia[0].valor == Valor.DEZ && sequencia[4].valor == Valor.AS
        } else {
            return false
        }
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }

}
