package services

import dominio.Mesa
import enuns.Nipe
import enuns.Valor
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
		mesaCriada.listaDeCartas.size() == 5
		mesaCriada.listaDeCartas.get(0).valor == Valor.DOIS
		mesaCriada.listaDeCartas.get(0).nipe == Nipe.ESPADAS

		mesaCriada.listaDeCartas.get(1).valor == Valor.DEZ
		mesaCriada.listaDeCartas.get(1).nipe == Nipe.PAUS

		mesaCriada.listaDeCartas.get(2).valor == Valor.NOVE
		mesaCriada.listaDeCartas.get(2).nipe == Nipe.OUROS

		mesaCriada.listaDeCartas.get(3).valor == Valor.NOVE
		mesaCriada.listaDeCartas.get(3).nipe == Nipe.PAUS

		mesaCriada.listaDeCartas.get(4).valor == Valor.SETE
		mesaCriada.listaDeCartas.get(4).nipe == Nipe.COPAS
	}
}
