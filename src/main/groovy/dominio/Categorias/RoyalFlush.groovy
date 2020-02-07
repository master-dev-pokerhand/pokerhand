package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class RoyalFlush extends StraightFlush {

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        if(super.ehCategoria(cartas)){

        }
        this.sequencia.sort()
        return sequencia[0].valor.valor == 10 && sequencia[4].valor.valor == 14
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }

}
