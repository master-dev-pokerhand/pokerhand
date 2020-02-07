package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.UmPar
import dominio.Jogador
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class UmParSpec extends Specification {

	def 'identifição de mão contendo Um Par'() {
		setup:
		Jogador jogador1 = new Jogador()

		jogador1.mao = getCartas_p1()

		Categoria categoria = new UmPar()

		when:
		Boolean possuiUmPar = categoria.ehCategoria(jogador1.mao)

		then:
		possuiUmPar

	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.DEZ, Nipe.PAUS))
		cartas.add(new Carta(Valor.VALETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.DAMA, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		return cartas
	}

}