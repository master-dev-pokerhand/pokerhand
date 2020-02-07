package services

import dominio.Mesa
import spock.lang.Specification

class MesaServiceSpec extends Specification{

	void 'cria mesa corretamente'(){
		given:
		MesaService mesaService = new MesaService()
		String mesa = '2s Tc 9d 9c 7h'
		when:
		Mesa mesaCriada = mesaService.criaMesa(mesa)
		then:
		mesaCriada
	}
}
