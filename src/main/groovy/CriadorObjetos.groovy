import dominio.Rodada
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import services.RodadaService

class CriadorObjetos {

	static List<Rodada> criaTodasAsRodadas(String json) {
		if (!json) {
			return []
		}

		RodadaService rodadaService = new RodadaService()

		JsonSlurper jsonSlurper = new JsonSlurper()
		List<LazyMap> jogos = jsonSlurper.parseText(json) as List<LazyMap>

		List<Rodada> todasRodadas = []
		for (LazyMap jogo in jogos) {
			LazyMap rodadas = jogo.values().flatten() as LazyMap
			todasRodadas.addAll(rodadaService.criaRodadas(rodadas))
		}
		return todasRodadas
	}
}
