class ApiGetter {

	static String obtemJson(){
		URLConnection get = new URL("http://172.22.0.255:3333/dados-pokerhand").openConnection()
		String jsonResponse = get.getInputStream().getText()
		return jsonResponse
	}

}
