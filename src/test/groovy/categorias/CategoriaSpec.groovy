package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.RoyalFlush
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class CategoriaSpec extends Specification {
    Categoria categoria = new RoyalFlush();

    def 'obtem maior carta corretamente'() {
        when:
        Carta maiorCarta = categoria.obtemMaiorCarta(cartas)

        then:
        maiorCarta?.valor == cartaResposta?.valor

        and:
        maiorCarta?.nipe == cartaResposta?.nipe

        where:
        cartas                                               | cartaResposta
        getCartasBase()                                      | new Carta(Valor.REI, Nipe.ESPADAS)
        getCartasBase() + [new Carta(Valor.REI, Nipe.OUROS)] | null

    }

    def 'obtem cartas agrupadas por valor'(){
        when:
        List<String, List<Carta>> mapa = categoria.obtemCartasComMesmoValor(getCartasBase())

        then:
        mapa
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.OITO, Nipe.PAUS))
        cartas.add(new Carta(Valor.DOIS, Nipe.OUROS))
        cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
        cartas.add(new Carta(Valor.QUATRO, Nipe.OUROS))
        cartas.add(new Carta(Valor.OITO, Nipe.ESPADAS))
        return cartas
    }
}
