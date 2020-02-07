package services

import dominio.Categorias.CartaAlta
import dominio.Categorias.Categoria
import dominio.Categorias.DoisPares
import dominio.Categorias.Flush
import dominio.Categorias.FullHouse
import dominio.Categorias.Quadra
import dominio.Categorias.RoyalFlush
import dominio.Categorias.Sequencia
import dominio.Categorias.StraightFlush
import dominio.Categorias.Trinca
import dominio.Categorias.UmPar
import dominio.Jogador
import dominio.Mesa
import dominio.Rodada
import enuns.Categorias
import groovy.json.internal.LazyMap

class RodadaService {

	private List<Class> classesCategorias = [
			RoyalFlush,
			StraightFlush,
			Quadra,
			FullHouse,
			Flush,
			Sequencia,
			Trinca,
			DoisPares,
			UmPar,
			CartaAlta
	]

	Rodada criaRodada(String nomeRodada, LazyMap mesaEJogadores) {
		MesaService mesaService = new MesaService()
		JogadorService jogadorService = new JogadorService()
		Rodada rodada = new Rodada()

		Mesa mesa = mesaService.criaMesa(mesaEJogadores.get('board') as String)
		List<Jogador> jogadores = jogadorService.criaJogadores(mesaEJogadores.findAll {
			it.key != 'board'
		} as LazyMap, mesa)

		rodada.mesa = mesa
		rodada.jogadores = jogadores

		return rodada
	}

	List<Rodada> criaRodadas(LazyMap rodadas) {
		List<Rodada> rodadasCriadas = []
		rodadas.each { String nomeRodada, LazyMap mesaEJogadores ->
			rodadasCriadas.add(criaRodada(nomeRodada, mesaEJogadores))
		}
		return rodadasCriadas
	}

	Jogador encontraVencedorRodada(Rodada rodada) {
		Jogador vencedor = null

		Map<Categorias, List<Jogador>> jogadoresPorCategoria = rodada.jogadores.groupBy { it.jogada.categoria }
		List<Categorias> categoriasOrdenadas = jogadoresPorCategoria.keySet().sort(false) { Categorias categoria -> categoria.categoria }
		Categorias maiorCategoria = categoriasOrdenadas.last()

		List<Jogador> candidatos = jogadoresPorCategoria.get(maiorCategoria)

		if (candidatos.size() == 1) {
			vencedor = candidatos.first()
		} else {
			for (Class categoria in classesCategorias) {

				Categoria categoriaClass = categoria.newInstance() as Categoria
				if (categoriaClass.categoria_enum == maiorCategoria) {
					vencedor = categoriaClass.desempate(candidatos)
				}
			}

		}
		return vencedor
	}
}
