package services
import groovy.json.internal.LazyMap
import dominio.Jogador

class JogadorService {

	Jogador criaJogador(String nomeJogador, String cartas) {
		CartaService cartaService = new CartaService()

		Jogador jogador = new Jogador()
		jogador.mao = cartaService.criaCartas(cartas)
		jogador.nome = nomeJogador
		return jogador
	}

	List<Jogador> criaJogadores(LazyMap jogadores) {
		List<Jogador> jogadoresCriados = []
		jogadores.each { String nomeJogador, String cartas ->
			jogadoresCriados.add(criaJogador(nomeJogador, cartas))
		}
		return jogadoresCriados
	}
}
