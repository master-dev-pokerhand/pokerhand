package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.Sequencia
import dominio.Jogada
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class SequenciaSpec extends Specification {

	def 'identificação de mão não contendo uma sequência'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogada jogada1 = new Jogada()

		jogador1.jogada = jogada1

		jogador1.jogada.cartasDaJogada = getCartas_p1_sucesso()

		Categoria categoria = new Sequencia()

		when:
		Boolean possuiSequencia = categoria.ehCategoria(jogador1.jogada.cartasDaJogada)

		then:
		possuiSequencia

	}

	def 'identificação de mão  contendo uma sequência'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogada jogada1 = new Jogada()

		jogador1.jogada = jogada1

		jogador1.jogada.cartasDaJogada = getCartas_p1_sucesso()

		Categoria categoria = new Sequencia()

		when:
		Boolean possuiSequencia = categoria.ehCategoria(jogador1.jogada.cartasDaJogada)

		then:
		possuiSequencia

	}

	def 'desempata jogada'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		Jogada jogada1 = new Jogada()
		Jogada jogada2 = new Jogada()

		jogador1.jogada = jogada1
		jogador2.jogada = jogada2

		jogador1.jogada.cartasDaJogada = getCartas_p1_sucesso()
		jogador2.jogada.cartasDaJogada = getCartas_p2_sucesso()

		Categoria categoria = new Sequencia()

		when:
		Jogador jogador = categoria.desempate([jogador1,jogador2])

		then:
		jogador == jogador2
	}

	def 'jogada termina empatada'() {
		setup:
		Jogador jogador1 = new Jogador()
		Jogador jogador2 = new Jogador()

		Jogada jogada1 = new Jogada()
		Jogada jogada2 = new Jogada()

		jogador1.jogada = jogada1
		jogador2.jogada = jogada2

		jogador1.jogada.cartasDaJogada = getCartas_p2_sucesso()
		jogador2.jogada.cartasDaJogada = getCartas_p1_empate_p2()

		Categoria categoria = new Sequencia()

		when:
		Jogador jogador = categoria.desempate([jogador1,jogador2])

		then:
		!jogador
	}


	List<Carta> getCartas_p1_falha() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.DOIS, Nipe.OUROS))
		cartas.add(new Carta(Valor.DOIS, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
		return cartas
	}

	List<Carta> getCartas_p1_sucesso() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.DOIS, Nipe.OUROS))
		cartas.add(new Carta(Valor.DOIS, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.OUROS))
		cartas.add(new Carta(Valor.CINCO, Nipe.PAUS))
		cartas.add(new Carta(Valor.SEIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
		return cartas
	}

	List<Carta> getCartas_p2_sucesso() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
		cartas.add(new Carta(Valor.SEIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.SETE, Nipe.PAUS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		return cartas
	}

	List<Carta> getCartas_p1_empate_p2() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.DOIS, Nipe.OUROS))
		cartas.add(new Carta(Valor.DOIS, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.TRES, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.OUROS))
		cartas.add(new Carta(Valor.CINCO, Nipe.PAUS))
		cartas.add(new Carta(Valor.SEIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.SETE, Nipe.OUROS))
		return cartas
	}
}