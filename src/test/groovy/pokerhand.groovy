import dominio.Rodada
import spock.lang.Specification

class pokerhand extends Specification{

	void 'teste generico'(){
		given:
//		String json = ApiGetter.obtemJson()
		List<Rodada> rodadas = CriadorObjetos.criaTodasAsRodadas('')
		when:
		true
		then:
		true
	}
}
