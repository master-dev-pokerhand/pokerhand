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
        Map<Valor, List<Carta>> mapaCartas = categoria.obtemCartasComMesmoValor(getCartasBase())

        then:
        mapaCartas[Valor.CINCO].size() == 1
        mapaCartas[Valor.REI].size() == 1
        mapaCartas[Valor.OITO].size() == 2
        mapaCartas[Valor.DOIS].size() == 1
        mapaCartas[Valor.TRES].size() == 1
        mapaCartas[Valor.QUATRO].size() == 1
    }

    def 'obtem cartas agrupadas por nipe'(){
        when:
        Map<Nipe, List<Carta>> mapaCartas = categoria.obtemCartasComMesmoNipe(getCartasBase())

        then:
        mapaCartas[Nipe.OUROS].size() == 3
        mapaCartas[Nipe.ESPADAS].size() == 2
        mapaCartas[Nipe.PAUS].size() == 1
        mapaCartas[Nipe.COPAS].size() == 1
    }

    List<Carta> getCartasBase() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.OITO, Nipe.OUROS))
        cartas.add(new Carta(Valor.DOIS, Nipe.OUROS))
        cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
        cartas.add(new Carta(Valor.QUATRO, Nipe.COPAS))
        cartas.add(new Carta(Valor.OITO, Nipe.ESPADAS))
        return cartas
    }
}
