package services

import dominio.Jogador
import dominio.Mesa

class CategoriaService {

	void obtemJogada(Jogador jogador, Mesa mesa) {
		jogador.jogada = null
	}
}
