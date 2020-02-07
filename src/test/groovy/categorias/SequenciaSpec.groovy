package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.Sequencia
import dominio.Jogada
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class SequenciaSpec extends Specification {

	def 'identifição de mão não contendo uma sequência'() {
		setup:
		Jogada jogada1 = new Jogada()

		jogada1.cartasDaJogada = getCartas_p1_falha()

		Categoria categoria = new Sequencia()

		when:
		Boolean possuiSequencia = categoria.ehCategoria(jogada1.cartasDaJogada)

		then:
		!possuiSequencia

	}

	def 'identifição de mão  contendo uma sequência'() {
		setup:
		Jogada jogada1 = new Jogada()

		jogada1.cartasDaJogada = getCartas_p1_sucesso()

		Categoria categoria = new Sequencia()

		when:
		Boolean possuiSequencia = categoria.ehCategoria(jogada1.cartasDaJogada)

		then:
		possuiSequencia

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
}