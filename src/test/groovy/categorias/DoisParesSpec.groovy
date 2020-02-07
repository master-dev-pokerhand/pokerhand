package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.DoisPares
import dominio.Jogada
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class DoisParesSpec extends Specification {

	def 'identificação de mão contendo Dois Pares'() {
		setup:
		Jogada jogada1 = new Jogada()

		jogada1.cartasDaJogada = getCartas_p1()

		Categoria categoria = new DoisPares()

		when:
		Boolean possuiDoisPares = categoria.ehCategoria(jogada1.cartasDaJogada)

		then:
		possuiDoisPares

	}

	def 'desempata jogada entre dois Pares'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		Jogada jogada1 = new Jogada()
		Jogada jogada2 = new Jogada()

		jogador1.jogada = jogada1
		jogador2.jogada = jogada2

		jogador1.jogada.cartasDaJogada = getCartas_p1()
		jogador2.jogada.cartasDaJogada = getCartas_p2()

		Categoria categoria = new DoisPares()

		when:
		Jogador jogador = categoria.desempate([jogador1,jogador2])

		then:
		jogador == jogador1
	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.AS, Nipe.PAUS))
		cartas.add(new Carta(Valor.AS, Nipe.OUROS))
		cartas.add(new Carta(Valor.DAMA, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		return cartas
	}

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.PAUS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.PAUS))
		return cartas
	}
}