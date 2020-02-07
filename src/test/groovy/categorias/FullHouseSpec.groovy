package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.Flush
import dominio.Categorias.FullHouse
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class FullHouseSpec extends Specification {
    def 'verifica se a jogada é um fullhouse corretamente'() {
        setup:
        FullHouse fullHouse = new FullHouse()

        when:
        boolean resultado = fullHouse.ehCategoria(cartas)

        then:
        resultado == resultadoEsperado

        where:
        cartas                                                                                  | resultadoEsperado
        getCartasBase() + [new Carta(Valor.DAMA, Nipe.PAUS), new Carta(Valor.DOIS, Nipe.PAUS)]  | true
        getCartasBase() + [new Carta(Valor.DAMA, Nipe.PAUS), new Carta(Valor.DAMA, Nipe.OUROS)] | true
        getCartasBase() + [new Carta(Valor.DOIS, Nipe.PAUS), new Carta(Valor.AS, Nipe.OUROS)]   | false
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.REI, Nipe.PAUS))
        cartas.add(new Carta(Valor.REI, Nipe.COPAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.DAMA, Nipe.COPAS))
        return cartas
    }
}
