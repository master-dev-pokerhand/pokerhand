package dtos

class JogadorDTO {
	String nome
	String cartas

	JogadorDTO(Map<String,String> jogador){
		this.nome = jogador.keySet()[0]
		this.cartas = jogador.values()[0]
	}
}
