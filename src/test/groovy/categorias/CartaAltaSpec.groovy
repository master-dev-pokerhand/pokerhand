package categorias

import dominio.Carta
import dominio.Categorias.CartaAlta
import dominio.Categorias.Categoria
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class CartaAltaSpec extends Specification {

	def 'obtem desempate corretamente entre Cartas Altas'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		jogador1.mao = getCartas_p1()
		jogador2.mao = getCartas_p2()

		Categoria categoria = new CartaAlta()

		when:
		Jogador ganhador = categoria.desempate([jogador1, jogador2])

		then:
		ganhador == jogador2

	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.SEIS, Nipe.ESPADAS))
		return cartas
	}

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.SETE, Nipe.ESPADAS))
		return cartas
	}
}