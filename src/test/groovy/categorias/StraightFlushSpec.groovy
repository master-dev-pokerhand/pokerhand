package categorias

import dominio.Carta
import dominio.Categorias.StraightFlush
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

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.SEIS, Nipe.COPAS))
        cartas.add(new Carta(Valor.DEZ, Nipe.COPAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.OITO, Nipe.COPAS))
        cartas.add(new Carta(Valor.NOVE, Nipe.COPAS))
        cartas.add(new Carta(Valor.NOVE, Nipe.PAUS))
        return cartas
    }
}
