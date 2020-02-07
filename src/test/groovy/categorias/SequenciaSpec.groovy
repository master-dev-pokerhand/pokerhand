package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.Sequencia
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class SequenciaSpec extends Specification {

	def 'identifição de mão contendo uma sequência'() {
		setup:
		Jogador jogador1 = new Jogador()

		jogador1.mao = getCartas_p1()

		Categoria categoria = new Sequencia()

		when:
		Boolean possuiSequencia = categoria.ehCategoria(jogador1.mao)

		then:
		assert possuiSequencia

	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.DOIS, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		cartas.add(new Carta(Valor.CINCO, Nipe.OUROS))
		cartas.add(new Carta(Valor.SEIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.OUROS))
		return cartas
	}
}