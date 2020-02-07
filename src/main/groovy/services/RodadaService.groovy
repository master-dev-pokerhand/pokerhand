package services

import dominio.Categorias.CartaAlta
import dominio.Jogador
import dominio.Mesa
import dominio.Rodada
import groovy.json.internal.LazyMap

class RodadaService {

	Rodada criaRodada(String nomeRodada, LazyMap mesaEJogadores){
		MesaService mesaService = new MesaService()
		JogadorService jogadorService = new JogadorService()
		Rodada rodada = new Rodada()

		Mesa mesa = mesaService.criaMesa(mesaEJogadores.get('board') as String)
		List<Jogador> jogadores = jogadorService.criaJogadores(mesaEJogadores.findAll {it.key != 'board'} as LazyMap, mesa)

		rodada.mesa = mesa
		rodada.jogadores = jogadores

		return rodada
	}

	List<Rodada> criaRodadas(LazyMap rodadas){
		List<Rodada> rodadasCriadas = []
		rodadas.each { String nomeRodada, LazyMap mesaEJogadores ->
			rodadasCriadas.add(criaRodada(nomeRodada,mesaEJogadores))
		}
		return rodadasCriadas
	}
}
