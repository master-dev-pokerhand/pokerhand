package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.Trinca
import dominio.Jogada
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class TrincaSpec extends Specification {

	def 'identificação de mão contendo uma Trinca'() {
		setup:
		Jogada jogada1 = new Jogada()

		jogada1.cartasDaJogada = getCartas_p1()

		Categoria categoria = new Trinca()

		when:
		Boolean possuiTrinca = categoria.ehCategoria(jogada1.cartasDaJogada)

		then:
		possuiTrinca

	}

	def 'desempata jogada entre duas trincas'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		Jogada jogada1 = new Jogada()
		Jogada jogada2 = new Jogada()

		jogador1.jogada = jogada1
		jogador2.jogada = jogada2

		jogador1.jogada.cartasDaJogada = getCartas_p1()
		jogador2.jogada.cartasDaJogada = getCartas_p2()

		Categoria categoria = new Trinca()

		when:
		Jogador jogador = categoria.desempate([jogador1,jogador2])

		then:
		jogador == jogador2
	}

	List<Carta> getCartas_p1() {
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

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.REI, Nipe.PAUS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.PAUS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.PAUS))
		return cartas
	}
}