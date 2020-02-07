package dominio.Categorias

import dominio.Carta
import dominio.Jogador
import enuns.Categorias

abstract class Categoria {
	Boolean ehCategoria(List<Carta> cartas)
	Jogador desempate(Jogador jogador1, Jogador jogador2)
	Carta obtemMaiorCarta(List<Carta> mao)
	Map<String, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas)
	Map<String, List<Carta>> obtemCartasComMesmoNaipe(List<Carta> cartas)
}
