package dominio

import enuns.Nipe
import enuns.Valor

class Carta {
	Valor valor
	Nipe nipe

	Carta(String carta){
		List<String> cartaList = carta.toList()
		this.nipe = Nipe.getEnum(cartaList[1])
		this.valor = Valor.getEnum(cartaList[0])
	}
}
