package dominio.Categorias

import dominio.Carta
import dominio.Jogador

abstract class Categoria {
	abstract Boolean ehCategoria(List<Carta> cartas)

	abstract Jogador desempate(Jogador jogador1, Jogador jogador2)

	abstract Carta obtemMaiorCarta(List<Carta> mao)

	abstract Map<String, List<Carta>> obtemCartasComMesmoValor(List<Carta> cartas)

	abstract Map<String, List<Carta>> obtemCartasComMesmoNaipe(List<Carta> cartas)
}
