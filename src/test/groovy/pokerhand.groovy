import dominio.Jogador
import dominio.Rodada
import services.RodadaService
import spock.lang.Specification

class pokerhand extends Specification{

	void 'teste generico'(){
		given:
		RodadaService rodadaService = new RodadaService()
		String json = ApiGetter.obtemJson()
		List<Rodada> rodadas = CriadorObjetos.criaTodasAsRodadas(json)
		when:
		StringBuffer stringBuffer = new StringBuffer()
		rodadas.each {
			Jogador vencedor = rodadaService.encontraVencedorRodada(it)
			if(vencedor){
				stringBuffer.append(vencedor.nome + ' Venceu a rodada\n')
			} else {
				stringBuffer.append('A rodada terminou em empate\n')
			}
		}
		then:
		stringBuffer
	}

	String jsonTeste = """[
  {
    "poker": {
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
  }
]"""
}
