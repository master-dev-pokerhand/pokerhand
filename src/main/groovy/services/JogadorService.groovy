package services

import dominio.Mesa
import groovy.json.internal.LazyMap
import dominio.Jogador

class JogadorService {

	Jogador criaJogador(String nomeJogador, String cartas, Mesa mesa) {
		CartaService cartaService = new CartaService()
		JogadaService jogadaService = new JogadaService()

		Jogador jogador = new Jogador()
		jogador.mao = cartaService.criaCartas(cartas)
		jogador.nome = nomeJogador
		jogador.jogada = jogadaService.obtemJogadaJogador(jogador, mesa)
		return jogador
	}

	List<Jogador> criaJogadores(LazyMap jogadores, Mesa mesa) {
		List<Jogador> jogadoresCriados = []
		jogadores.each { String nomeJogador, String cartas ->
			jogadoresCriados.add(criaJogador(nomeJogador, cartas, mesa))
		}
		return jogadoresCriados
	}

}
