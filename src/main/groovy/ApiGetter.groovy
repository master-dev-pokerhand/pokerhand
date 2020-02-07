class ApiGetter {

	String getJson(){
		URLConnection get = new URL("https://httpbin.org/get").openConnection()
		String jsonResponse = get.getInputStream().getText()
		return jsonResponse
	}

}
