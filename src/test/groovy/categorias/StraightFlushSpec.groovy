package categorias

import dominio.Carta
import dominio.Categorias.StraightFlush
import dominio.Jogada
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class StraightFlushSpec extends Specification {
    def 'verifica se a jogada é uma straight flush corretamente'() {
        setup:
        StraightFlush straightFlush = new StraightFlush()

        when:
        boolean resultado = straightFlush.ehCategoria(cartas)

        then:
        resultado == resultadoEsperado

        where:
        cartas                                                | resultadoEsperado
        getCartasBase()                                       | false
        getCartasBase() + [new Carta(Valor.SETE, Nipe.COPAS)] | true
    }

    def 'o desempate do straight flush deve executar corretamente'() {
        setup:
        StraightFlush straightFlush = new StraightFlush()

        Jogada jogada1 = new Jogada()
        Jogador jogador1 = new Jogador()
        jogador1.jogada = jogada1
        jogador1.jogada.cartasDaJogada = getCartasBase() + [new Carta(Valor.VALETE, Nipe.COPAS)]

        Jogada jogada2 = new Jogada()
        Jogador jogador2 = new Jogador()
        jogador2.jogada = jogada2
        jogador2.jogada.cartasDaJogada = getCartasBase() + [new Carta(Valor.SEIS, Nipe.COPAS)]

        Jogada jogada3 = new Jogada()
        Jogador jogador3 = new Jogador()
        jogador3.jogada = jogada3
        jogador3.jogada.cartasDaJogada = getCartasBase() + [new Carta(Valor.DOIS, Nipe.PAUS)]

        when:
        Jogador campeao = straightFlush.desempate([jogador1, jogador2, jogador3])

        then:
        campeao == jogador1
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.SETE, Nipe.COPAS))
        cartas.add(new Carta(Valor.DEZ, Nipe.COPAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.OITO, Nipe.COPAS))
        cartas.add(new Carta(Valor.NOVE, Nipe.COPAS))
        cartas.add(new Carta(Valor.NOVE, Nipe.PAUS))
        return cartas
    }
}
