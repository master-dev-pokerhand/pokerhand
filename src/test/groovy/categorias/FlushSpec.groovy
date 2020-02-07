package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.Flush
import dominio.Jogada
import dominio.Jogador
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
		getCartas_p1() + [new Carta(Valor.SEIS, Nipe.COPAS)] | true
		getCartas_p1()                                       | false
    }


	def 'desempata jogada'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		Jogada jogada1 = new Jogada()
		Jogada jogada2 = new Jogada()

		jogador1.jogada = jogada1
		jogador2.jogada = jogada2

		jogador1.jogada.cartasDaJogada = getCartas_p2()
		jogador2.jogada.cartasDaJogada = getCartas_p3()

		Categoria categoria = new Flush()

		when:
		Jogador jogador = categoria.desempate([jogador1,jogador2])

		then:
		jogador == jogador1
	}

    List<Carta> getCartas_p1() {
        List<Carta> cartas = new ArrayList<>()
        cartas.add(new Carta(Valor.DOIS, Nipe.COPAS))
        cartas.add(new Carta(Valor.AS, Nipe.PAUS))
        cartas.add(new Carta(Valor.REI, Nipe.COPAS))
        cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
        cartas.add(new Carta(Valor.CINCO, Nipe.COPAS))
        cartas.add(new Carta(Valor.DAMA, Nipe.COPAS))
		cartas.add(new Carta(Valor.CINCO, Nipe.PAUS))
        return cartas
    }

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.AS, Nipe.OUROS))
		return cartas
	}

	List<Carta> getCartas_p3() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
		return cartas
	}
}
