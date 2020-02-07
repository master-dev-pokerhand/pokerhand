import dominio.Jogador
import dominio.Rodada
import services.RodadaService
import spock.lang.Specification

class pokerhand extends Specification {

	void 'teste generico'() {
		given:
		RodadaService rodadaService = new RodadaService()
		String json = ApiGetter.obtemJson()
		List<Rodada> rodadas = CriadorObjetos.criaTodasAsRodadas(json)
		when:

		StringBuffer stringBuffer = new StringBuffer()

		rodadas.each {
			Jogador vencedor = rodadaService.encontraVencedorRodada(it)
			if (vencedor) {
				stringBuffer.append(vencedor.nome + ' Venceu a rodada\n')
			} else {
				stringBuffer.append('A rodada terminou em empate\n')
			}
		}

		then:
		stringBuffer
	}
}
