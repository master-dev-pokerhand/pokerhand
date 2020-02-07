package categorias

import dominio.Carta
import dominio.Categorias.Categoria
import dominio.Categorias.DoisPares
import dominio.Jogada
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class DoisParesSpec extends Specification {

	def 'identifição de mão contendo Dois Pares'() {
		setup:
		Jogada jogada1 = new Jogada()

		jogada1.cartasDaJogada = getCartas_p1()

		Categoria categoria = new DoisPares()

		when:
		Boolean possuiDoisPares = categoria.ehCategoria(jogada1.cartasDaJogada)

		then:
		possuiDoisPares

	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.TRES, Nipe.OUROS))
		cartas.add(new Carta(Valor.TRES, Nipe.ESPADAS))
		cartas.add(new Carta(Valor.DEZ, Nipe.PAUS))
		cartas.add(new Carta(Valor.DEZ, Nipe.OUROS))
		cartas.add(new Carta(Valor.DAMA, Nipe.PAUS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		cartas.add(new Carta(Valor.QUATRO, Nipe.PAUS))
		return cartas
	}
}