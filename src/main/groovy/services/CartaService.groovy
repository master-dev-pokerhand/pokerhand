package services

import dominio.Carta

class CartaService {

	Carta criaCarta(String carta) {
		return new Carta(carta)
	}

	List<Carta> criaCartas(String cartas) {
		List<String> cartasParaCriar = cartas.tokenize(' ')
		List<Carta> cartasCriadas = []
		for (String carta in cartasParaCriar) {
			cartasCriadas.add(new Carta(carta))
		}
		return cartasCriadas
	}
}
