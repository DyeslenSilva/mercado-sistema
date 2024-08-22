package end.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class EnderecoCEP {

	public static void main(String[] args) throws IOException {
	
        String cep = "06654710"; // Exemplo de CEP
        String urlString = "https://viacep.com.br/ws/" + cep + "/json/";

		URL cepURL = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) cepURL.openConnection();
		
		conn.setRequestMethod("GET");
		conn.connect();
		
		Reader reader = new InputStreamReader(conn.getInputStream());
		JsonObject jObject = new Gson().fromJson(reader, JsonObject.class);
		
		System.out.println("Logradouro: "+jObject.get("logradouro").getAsString());
		System.out.println("Cidade: "+jObject.get("localidade").getAsString());
		System.out.println("Estado "+jObject.get("uf").getAsString());
		System.out.println("DDD: "+jObject.get("ddd").getAsInt());
	}
	
	
}
