import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public  class BuscaValor {
    public Moedas buscaValor(String Nome) throws IOException, InterruptedException {
        String base = Nome.toUpperCase();
        String apiKey = ChaveApi.getApiKey();

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(resposta.body(), Moedas.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível concluir. Tente novamente.");
        }

    }
}
