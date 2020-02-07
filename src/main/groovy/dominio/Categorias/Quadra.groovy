package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Valor

class Quadra extends Categoria {
    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        Map<Valor, List<Carta>> mapaValores = obtemCartasComMesmoValor(cartas)
        return !mapaValores.values().findAll { List<Carta> cartalist -> cartalist.size() == 4 }.empty
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        return null
    }
}
