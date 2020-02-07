package enuns

enum Nipe {
	COPAS('h'),
	ESPADAS('s'),
	OUROS('d'),
	PAUS('c')

	Nipe(String value) {
		this.Nipe = value
	}

	private final String Nipe

	String getNipe() {
		return this.Nipe
	}

	static getEnum(String value){
		if(value == COPAS.nipe)
			return COPAS
		if(value == ESPADAS.nipe)
			return ESPADAS
		if(value == OUROS.nipe)
			return OUROS
		if(value == PAUS.nipe)
			return PAUS
	}

}

