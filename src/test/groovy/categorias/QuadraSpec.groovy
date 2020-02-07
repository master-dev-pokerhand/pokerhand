package categorias

import dominio.Carta
import dominio.Categorias.Quadra
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
        cartas                                                | resultadoEsperado
        getCartasBase() + [new Carta(Valor.AS, Nipe.OUROS)]   | true
        getCartasBase() + [new Carta(Valor.DOIS, Nipe.OUROS)] | false
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.AS, Nipe.COPAS))
        cartas.add(new Carta(Valor.AS, Nipe.PAUS))
        cartas.add(new Carta(Valor.AS, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.CINCO, Nipe.COPAS))
        cartas.add(new Carta(Valor.DAMA, Nipe.COPAS))
        return cartas
    }
}
