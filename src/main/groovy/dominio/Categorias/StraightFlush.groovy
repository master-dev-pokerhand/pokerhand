package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Valor

class StraightFlush extends Sequencia {

    Categorias categoria_enum = Categorias.STRAIGHT_FLUSH

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        return !getStraightFlush(cartas).empty
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        List<Jogador> campeao = [jogadores.first()]
        for (int i = 1; i < jogadores.size(); i++) {
            List<Carta> straightFlushCampeao = getStraightFlush(campeao.first().jogada.cartasDaJogada)
            List<Carta> straightFlushJogador = getStraightFlush(jogadores[i].jogada.cartasDaJogada)
            Carta maiorCartaCampeao = obtemMaiorCarta(straightFlushCampeao)
            Carta maiorCartaJogador = obtemMaiorCarta(straightFlushJogador)

            if(maiorCartaJogador && maiorCartaJogador.valor.valor > maiorCartaCampeao.valor.valor){
                campeao.clear()
                campeao.add(jogadores[i])
            } else if (maiorCartaJogador && maiorCartaJogador == maiorCartaCampeao){
                campeao.add(jogadores[i])
            }
        }
        return campeao.size() == 1 ? campeao.first() : null
    }

    List<Carta> getStraightFlush(List<Carta> cartas) {
        Map<Valor, List<Carta>> mapaNipe = obtemCartasComMesmoNipe(cartas)
        List<Carta> cartasFlush = mapaNipe.values().findAll { it -> it.size() == 5 }
        if (!cartasFlush.empty) {
            List<Carta> cartasOrdenadas = cartasFlush.first().sort { it -> it.valor.valor }
            return getSequencia(cartasOrdenadas)
        } else {
            return cartasFlush
        }
    }
}
