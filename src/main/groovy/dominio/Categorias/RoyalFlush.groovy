package dominio.Categorias

import dominio.Carta
import dominio.Jogador

class RoyalFlush extends Categoria {

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        return null
    }

    @Override
    Jogador desempate(Jogador jogador1, Jogador jogador2) {
        return null
    }
}
