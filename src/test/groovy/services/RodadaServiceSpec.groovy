package services

import dominio.Jogador
import dominio.Rodada
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import spock.lang.Specification

class RodadaServiceSpec extends Specification{

	void 'Cria Rodadas'(){
		given:
		RodadaService rodadaService = new RodadaService()
		JsonSlurper jsonSlurper = new JsonSlurper()
		LazyMap rodadasJson = jsonSlurper.parseText(jsonTeste) as LazyMap
		when:
		List<Rodada> rodadas = rodadaService.criaRodadas(rodadasJson)
		then:
		rodadas.size() == rodadasJson.size()
	}

	void 'Encontra Vencedor'(){
		given:
		RodadaService rodadaService = new RodadaService()
		JsonSlurper jsonSlurper = new JsonSlurper()
		LazyMap rodadasJson = jsonSlurper.parseText(jsonTeste) as LazyMap
		List<Rodada> rodadas = rodadaService.criaRodadas(rodadasJson)
		when:
		Jogador vencedor = rodadaService.encontraVencedorRodada(rodadas.first())
		then:
		vencedor.nome == 'p0'
	}


	String jsonTeste = """[
  {
      "h0": {
        "board": "2s Tc 9d 9c 7h",
        "p0": "Ah Qc",
        "p1": "4c Kd"
      },
      "h1": {
        "board": "Ah 6h 2s 5h 7d",
        "p0": "9h Jd",
        "p1": "Qc 6s"
      },
      "h2": {
        "board": "Jh 5h 9h 8h 8c",
        "p0": "2c 3c",
        "p1": "Qd 4d"
      },
      "h3": {
        "board": "6c 6h 3c 4s 5s",
        "p0": "8c Kc",
        "p1": "3d Ah"
      }
  }
]"""
}
