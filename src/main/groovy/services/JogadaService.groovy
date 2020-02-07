package services

import dominio.Carta
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
import dominio.Jogada
import dominio.Jogador
import dominio.Mesa
import enuns.Categorias

class JogadaService {

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

	Jogada obtemJogadaJogador(Jogador jogador, Mesa mesa) {
		if (!mesa || !jogador) {
			return null
		}
		List<Carta> todaAsCartas = jogador.mao + mesa.listaDeCartas

		for (Class categoria in classesCategorias) {
			Categoria categoriaClass = categoria.newInstance() as Categoria
			Boolean ehCategoria = categoriaClass.ehCategoria(todaAsCartas)
			if (ehCategoria) {
				Jogada jogada = new Jogada()
				jogada.cartasDaJogada = todaAsCartas
				jogada.categoria = (Categorias) categoriaClass.categoria_enum
				return jogada
			}
		}
		return null
	}
}
