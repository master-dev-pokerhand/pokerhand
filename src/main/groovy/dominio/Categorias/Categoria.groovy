package dominio.Categorias

import dominio.Carta
import dominio.Jogador

interface Categoria {
	Boolean ehCategoria(List<Carta> cartas)
	Jogador desempate(Jogador jogador1, Jogador jogador2)
	Carta obtemMaiorCarta(List<Carta> mao)
}