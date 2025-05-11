import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ChaveApi {
    public static String getApiKey() {
        Properties propriedades = new Properties();
        try {
            propriedades.load(new FileInputStream("config.properties"));
            return propriedades.getProperty("api_key");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar chave da API.", e);
        }
    }
}
