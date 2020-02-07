package categorias

import dominio.Carta
import dominio.Categorias.Flush
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class FlushSpec extends Specification {
    def 'verifica se a jogada é um flush corretamente'() {
        setup:
        Flush flush = new Flush()

        when:
        boolean resultado = flush.ehCategoria(cartas)

        then:
        resultado == resultadoEsperado

        where:
        cartas                                                | resultadoEsperado
        getCartasBase() + [new Carta(Valor.SEIS, Nipe.COPAS)] | true
        getCartasBase()                                       | false
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.DOIS, Nipe.COPAS))
        cartas.add(new Carta(Valor.AS, Nipe.PAUS))
        cartas.add(new Carta(Valor.REI, Nipe.COPAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.CINCO, Nipe.COPAS))
        cartas.add(new Carta(Valor.DAMA, Nipe.COPAS))
        return cartas
    }
}
