package services

import dominio.Jogador
import dtos.JogadorDTO

class JogadorService {

	Jogador criaJogador(String nomeJogador, String cartas) {
		CartaService cartaService = new CartaService()

		Jogador jogador = new Jogador()
		jogador.mao = cartaService.criaCartas(cartas)
		jogador.nome = nomeJogador
		return jogador
	}

	List<Jogador> criaJogadores(List<Map<String,String>> jogadores) {
		List<Jogador> jogadoresCriados = []
		for (Map<String,String> jogador in jogadores) {
			JogadorDTO dto = new JogadorDTO(jogador)
			jogadoresCriados.add(criaJogador(dto.nome, dto.cartas))
		}
		return jogadoresCriados
	}
}
