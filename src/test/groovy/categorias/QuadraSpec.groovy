package categorias

import dominio.Carta
import dominio.Categorias.Quadra
import dominio.Jogada
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class QuadraSpec extends Specification {
    def 'verifica se a jogada é uma quadra corretamente'() {
        setup:
        Quadra quadra = new Quadra()

        when:
        boolean resultado = quadra.ehCategoria(cartas)

        then:
        resultado == resultadoEsperado

        where:
        cartas                                                                                      | resultadoEsperado
        getCartasBase() + [new Carta(Valor.AS, Nipe.OUROS), new Carta(Valor.AS, Nipe.ESPADAS)]      | true
        getCartasBase() + [new Carta(Valor.TRES, Nipe.OUROS), new Carta(Valor.CINCO, Nipe.ESPADAS)] | false
    }

    def 'o desempate da quadra deve executar corretamente'() {
        setup:
        Quadra quadra = new Quadra()

        Jogada jogada1 = new Jogada()
        Jogador jogador1 = new Jogador()
        jogador1.jogada = jogada1
        jogador1.jogada.cartasDaJogada = getCartasBase() + [new Carta(Valor.AS, Nipe.OUROS), new Carta(Valor.AS, Nipe.ESPADAS)]

        Jogada jogada2 = new Jogada()
        Jogador jogador2 = new Jogador()
        jogador2.jogada = jogada2
        jogador2.jogada.cartasDaJogada = getCartasBase() + [new Carta(Valor.REI, Nipe.OUROS), new Carta(Valor.REI, Nipe.PAUS)]

        when:
        Jogador campeao = quadra.desempate([jogador1, jogador2])

        then:
        campeao == jogador1
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.AS, Nipe.COPAS))
        cartas.add(new Carta(Valor.AS, Nipe.PAUS))
        cartas.add(new Carta(Valor.DOIS, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.REI, Nipe.COPAS))
        return cartas
    }
}
