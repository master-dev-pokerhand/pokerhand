package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias
import enuns.Valor

class Quadra extends Categoria {

    Categorias categoria_enum = Categorias.QUADRA

    @Override
    Boolean ehCategoria(List<Carta> cartas) {
        Map<Valor, List<Carta>> mapaValores = obtemCartasComMesmoValor(cartas)
        return !mapaValores.values().findAll { List<Carta> cartalist -> cartalist.size() == 4 }.empty
    }

    @Override
    Jogador desempate(List<Jogador> jogadores) {
        Jogador campeao = jogadores.first()
        for (int i = 1; i < jogadores.size(); i++) {
            Map<Valor, List<Carta>> mapaValoresCampeao = obtemCartasComMesmoValor(campeao.jogada.cartasDaJogada)
            Map<Valor, List<Carta>> mapaValoresJogador = obtemCartasComMesmoValor(jogadores[i].jogada.cartasDaJogada)
            List<Carta> quadraCampeao = mapaValoresCampeao.values().findAll { List<Carta> cartalist -> cartalist.size() == 4 }.first()
            List<Carta> quadraJogador = mapaValoresJogador.values().findAll { List<Carta> cartalist -> cartalist.size() == 4 }.first()
            if(quadraJogador && quadraJogador.first().valor.valor > quadraCampeao.first().valor.valor){
                campeao = jogadores[i]
            }
        }
        return campeao
    }
}
