package dominio

import enuns.Nipe
import enuns.Valor

class Carta {
	Valor valor
	Nipe nipe

	Carta(Valor valor, Nipe nipe){
		this.valor = valor
		this.nipe = nipe
	}
}