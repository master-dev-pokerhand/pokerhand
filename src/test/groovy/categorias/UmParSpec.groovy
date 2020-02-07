package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.UmPar
import dominio.Jogada
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class UmParSpec extends Specification {

	def 'identificação de mão contendo Um Par'() {
		setup:
		Jogada jogada1 = new Jogada()

		jogada1.cartasDaJogada = getCartas_p1()

		Categoria categoria = new UmPar()

		when:
		Boolean possuiUmPar = categoria.ehCategoria(jogada1.cartasDaJogada)

		then:
		possuiUmPar

	}

	def 'obtem desempate corretamente entre Pares'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		jogador1.mao = getCartas_p1()
		jogador2.mao = getCartas_p2()

		Categoria categoria = new UmPar()

		when:
		Jogador ganhador = categoria.desempate([jogador1, jogador2])

		then:
		ganhador == jogador1

	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.ESPADAS))
		return cartas
	}

	List<Carta> getCartas_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.DAMA, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		return cartas
	}

}
