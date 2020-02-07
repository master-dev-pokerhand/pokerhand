package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.FullHouse
import dominio.Jogada
import dominio.Jogador
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

	def 'desempata jogada entre dois Full Houses'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		Jogada jogada1 = new Jogada()
		Jogada jogada2 = new Jogada()

		jogador1.jogada = jogada1
		jogador2.jogada = jogada2

		jogador1.jogada.cartasDaJogada = getCartas_p1()
		jogador2.jogada.cartasDaJogada = getCartas_p2()

		Categoria categoria = new FullHouse()

		when:
		Jogador jogador = categoria.desempate([jogador1, jogador2])

		then:
		jogador == jogador1
	}

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.DEZ, Nipe.OUROS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		return cartas
	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.REI, Nipe.PAUS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.PAUS))
		return cartas
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
