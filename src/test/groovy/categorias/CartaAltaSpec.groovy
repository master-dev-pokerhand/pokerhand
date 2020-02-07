package categorias

import dominio.Carta
import dominio.Categorias.CartaAlta
import dominio.Categorias.Categoria
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class CartaAltaSpec extends Specification {

	def 'obtem maior carta corretamente entre Cartas Altas'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		jogador1.mao = getCartas_p1()
		jogador2.mao = getCartas_p2()

		List<Jogador> jogadores = []
		jogadores.addAll([jogador1, jogador2])

		Categoria categoria = new CartaAlta()

		when:
		Jogador ganhador = categoria.desempate(jogadores)

		then:
		categoria.obtemMaiorCarta(ganhador.mao).valor == Valor.REI

	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.SEIS, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.DEZ, Nipe.PAUS))
		cartas.add(new Carta(Valor.VALETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.DAMA, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		return cartas
	}

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.SEIS, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.DEZ, Nipe.PAUS))
		cartas.add(new Carta(Valor.VALETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		return cartas
	}
}