package services

import dominio.Jogador
import dtos.JogadorDTO
import enuns.Nipe
import enuns.Valor
import spock.lang.Specification

class JogadorServiceSpec extends Specification{

	void 'cria jogador corretamente'(){
		given:
		JogadorService jogadorService = new JogadorService()
		when:
		Jogador jogador = jogadorService.criaJogador('zé','As 2h')
		then:
		jogador
		jogador.nome == 'zé'

		jogador.mao.get(0).nipe == Nipe.ESPADAS
		jogador.mao.get(0).valor == Valor.AS

		jogador.mao.get(1).nipe == Nipe.COPAS
		jogador.mao.get(1).valor == Valor.DOIS
	}

	void 'cria jogadoresDTO corretamente'(){
		when:
		JogadorDTO jogadorDTO = new JogadorDTO(['zé':'As 2h'])
		then:
		jogadorDTO.nome == 'zé'
		jogadorDTO.cartas == 'As 2h'
	}

	void 'cria jogadores corretamente'(){
		given:
		JogadorService jogadorService = new JogadorService()
		when:
		List<Jogador> jogador = jogadorService.criaJogadores([['zé':'As 2h'], ['mary': 'Kd 9c']])
		then:
		jogador

		and:
		Jogador amostra1 = jogador.get(0)
		amostra1.nome == 'zé'

		amostra1.mao.get(0).nipe == Nipe.ESPADAS
		amostra1.mao.get(0).valor == Valor.AS

		amostra1.mao.get(1).nipe == Nipe.COPAS
		amostra1.mao.get(1).valor == Valor.DOIS

		and:
		Jogador amostra2 = jogador.get(1)
		amostra2.nome == 'mary'

		amostra2.mao.get(0).nipe == Nipe.OUROS
		amostra2.mao.get(0).valor == Valor.REI

		amostra2.mao.get(1).nipe == Nipe.PAUS
		amostra2.mao.get(1).valor == Valor.NOVE
	}
}
