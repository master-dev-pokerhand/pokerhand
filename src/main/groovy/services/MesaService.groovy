package services

import dominio.Carta
import dominio.Mesa

class MesaService {
	Mesa criaMesa(String mesa) {
		CartaService cartaService = new CartaService()

		List<Carta> cartasDaMesa = cartaService.criaCartas(mesa)
		return new Mesa(cartasDaMesa)
	}
}
