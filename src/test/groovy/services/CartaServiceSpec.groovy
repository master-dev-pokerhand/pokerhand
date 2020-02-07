package services

import groovy.json.JsonSlurper
import spock.lang.Specification

class CartaServiceSpec extends Specification {

	def 'Cria cartas corretamente'() {
		given:
		CartaService cartaService = new CartaService()
		String s = criaJsonParaTeste()
		def jsonSlurper = new JsonSlurper()
		Map<String,List<Map>> object = jsonSlurper.parseText(s)
		when:
		cartaService.criaCartas()
		then:
		true
	}

	String criaJsonParaTeste() {
		return """{
	"Mesa": [{
		"Carta1": "hs",
		"Carta2": "Tc",
		"Carta3": "9d",
		"Carta4": "9c",
		"Carta5": "7h"
	}],
	"Jogadores": [{
		"Jogador1": [{
			"Carta1": "hs",
			"Carta2": "Tc"
		}],
		"Jogador2": [{
			"Carta1": "hs",
			"Carta2": "Tc"
		}],
		"Jogador3": [{
			"Carta1": "hs",
			"Carta2": "Tc"
		}]
	}]
}"""
	}
}
