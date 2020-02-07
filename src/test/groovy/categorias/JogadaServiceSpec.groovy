package categorias

import dominio.Carta
import dominio.Categorias.CartaAlta
import dominio.Categorias.Categoria
import dominio.Jogada
import dominio.Jogador
import dominio.Mesa
import enuns.Categorias
import enuns.Nipe
import enuns.Valor
import services.JogadaService
import spock.lang.Specification

class JogadaServiceSpec extends Specification {

	def 'obtem desempate corretamente entre Cartas Altas'() {
		setup:
		JogadaService jogadaService = new JogadaService()
		Jogador jogador1 = new Jogador()
		Mesa mesa = new Mesa()

		jogador1.mao = getCartas_p1()
		mesa.listaDeCartas = getCartas_mesa()

		when:
		Jogada jogada = jogadaService.obtemJogadaJogador(jogador1,mesa)

		then:
		jogada.categoria == Categorias.ROYAL_FLUSH

	}

	List<Carta> getCartas_mesa() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.AS, Nipe.OUROS))
		cartas.add(new Carta(Valor.REI, Nipe.OUROS))
		cartas.add(new Carta(Valor.DAMA, Nipe.OUROS))
		cartas.add(new Carta(Valor.VALETE, Nipe.OUROS))
		cartas.add(new Carta(Valor.DOIS, Nipe.PAUS))
		return cartas
	}

	List<Carta> getCartas_p1() {
		List<Carta> cartas = new ArrayList<>()
		cartas.add(new Carta(Valor.DEZ, Nipe.OUROS))
		cartas.add(new Carta(Valor.NOVE, Nipe.ESPADAS))
		return cartas
	}

}