package enuns

enum Valor {
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9),
	DEZ(10),
	VALETE(11),
	DAMA(12),
	REI(13),
	AS(14)

	Valor(int value) {
		this.valor = value
	}
	private final int valor

	int getValor() {
		return this.valor
	}

	static getEnum(String value){
		if(value == 'T')
			return DEZ
		if(value == 'J')
			return VALETE
		if(value == 'Q')
			return DAMA
		if(value == 'K')
			return REI
		if(value == 'A')
			return AS
		if(value.toInteger() == DOIS.valor)
			return DOIS
		if(value.toInteger()  == TRES.valor)
			return TRES
		if(value.toInteger()  == QUATRO.valor)
			return QUATRO
		if(value.toInteger()  == CINCO.valor)
			return CINCO
		if(value.toInteger()  == SEIS.valor)
			return SEIS
		if(value.toInteger()  == SETE.valor)
			return SETE
		if(value.toInteger()  == OITO.valor)
			return OITO
		if(value.toInteger()  == NOVE.valor)
			return NOVE
	}
}