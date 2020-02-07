package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias

class RoyalFlush extends StraightFlush {

    Categorias categoria_enum = Categorias.ROYAL_FLUSH

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
