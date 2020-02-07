import spock.lang.Specification

class CriadorObjetosSpec extends Specification{

	void 'cria objetos'(){
		when:
		CriadorObjetos criadorObjetos = new CriadorObjetos()
		List<Object> list = criadorObjetos.cria(jsonTeste)
		then:
		list
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
  },
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
