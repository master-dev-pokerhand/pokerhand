package categorias

import dominio.Carta
import dominio.Categorias.Quadra
import dominio.Categorias.RoyalFlush
import dominio.Categorias.StraightFlush
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class RoyalFlushSpec extends Specification {
    def 'verifica se a jogada é uma royal flush corretamente'() {
        setup:
        RoyalFlush royalFlush = new RoyalFlush()

        when:
        boolean resultado = royalFlush.ehCategoria(cartas)

        then:
        resultado == resultadoEsperado

        where:
        cartas                                                  | resultadoEsperado
        getCartasBase()                                         | false
        getCartasBase() + [new Carta(Valor.VALETE, Nipe.COPAS)] | true
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.AS, Nipe.COPAS))
        cartas.add(new Carta(Valor.DEZ, Nipe.COPAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.REI, Nipe.COPAS))
        cartas.add(new Carta(Valor.DAMA, Nipe.COPAS))
        cartas.add(new Carta(Valor.NOVE, Nipe.PAUS))
        return cartas
    }
}
