package services

import dominio.Carta
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class CartaServiceSpec extends Specification {

	def 'Cria nipe cartas corretamente'() {
		given:
		CartaService cartaService = new CartaService()
		when:
		Carta carta = cartaService.criaCarta(cartaExemplo)
		then:
		carta.nipe == nipeCerto
		where:
		cartaExemplo || nipeCerto
		"2s"         || Nipe.ESPADAS
		"2h"         || Nipe.COPAS
		"2d"         || Nipe.OUROS
		"2c"         || Nipe.PAUS
	}

	def 'Cria valor cartas corretamente'() {
		given:
		CartaService cartaService = new CartaService()
		when:
		Carta carta = cartaService.criaCarta(cartaExemplo)
		then:
		carta.valor == valorCerto
		where:
		cartaExemplo || valorCerto
		"2s"         || Valor.DOIS
		"3h"         || Valor.TRES
		"4d"         || Valor.QUATRO
		"5c"         || Valor.CINCO
		"6s"         || Valor.SEIS
		"7s"         || Valor.SETE
		"8s"         || Valor.OITO
		"9s"         || Valor.NOVE
		"Ts"         || Valor.DEZ
		"Js"         || Valor.VALETE
		"Qs"         || Valor.DAMA
		"Ks"         || Valor.REI
		"As"         || Valor.AS

	}

	def 'Cria varias cartas corretamente'() {
		given:
		CartaService cartaService = new CartaService()
		when:
		List<Carta> carta = cartaService.criaCartas(cartaExemplo)
		then:
		!carta.isEmpty()
		where:
		cartaExemplo = "2s 3h"
	}
}
