class ApiGetter {

	static String obtemJson(){
		URLConnection get = new URL("http://172.22.0.255:3333/dados-pokerhand").openConnection() //IP DA MAQUINA QUE ESTA RODANDO
		get.setReadTimeout(300000000i)
		String jsonResponse = get.getInputStream().getText()
		return jsonResponse
	}

}
