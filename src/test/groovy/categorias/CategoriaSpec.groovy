package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.RoyalFlush
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class CategoriaSpec extends Specification {
    def 'obtem maior carta corretamente'() {
        setup:
        List<Carta> cartas = getCartas()
        Categoria categoria = new RoyalFlush();

        when:
        Carta maiorCarta = categoria.obtemMaiorCarta(cartas)

        then:
        maiorCarta.valor == Valor.REI

        and:
        maiorCarta.nipe == Nipe.ESPADAS
    }

    List<Carta> getCartas(){
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
