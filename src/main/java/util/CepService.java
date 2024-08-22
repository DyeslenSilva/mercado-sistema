package util;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CepService {
 

	public static String buscaCEP(String cep, TextField endereco, TextField jfcidade,
			ComboBox<String> estado, TextField ddd) {

		String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return "Erro: Não foi possível conectar ao serviço ViaCEP.";
            }

            Reader reader = new InputStreamReader(conn.getInputStream());
            JsonObject json = new Gson().fromJson(reader, JsonObject.class);

            if (json.has("erro")) {
                return "CEP inválido.";
            }

            String logradouro = json.has("logradouro") ? json.get("logradouro").getAsString() : "N/A";
           // String bairro = json.has("bairro") ? json.get("bairro").getAsString() : "N/A";
          
            String cidade = json.has("localidade") ? json.get("localidade").getAsString() : "N/A";
            String uf = json.has("uf") ? json.get("uf").getAsString() : "N/A";
            int ufDDD = json.has("ddd") ? json.get("ddd").getAsInt() : -1; // Usando -1 como valor padrão
            
            if (ufDDD != -1) {
                ddd.setText(String.valueOf(ufDDD));
            } else {
                ddd.setText("N/A");
            }

            endereco.setText(logradouro);
            jfcidade.setText(cidade);
            estado.setValue(uf);

            result.append("Logradouro: ").append(logradouro).append("\n");
            result.append("Cidade: ").append(cidade).append("\n");
            result.append("UF: ").append(uf);
            result.append("DDD: ").append(ufDDD);
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao buscar o endereço: " + e.getMessage();
        }

        return result.toString();
		
	}
}
