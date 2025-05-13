import java.io.IOException;
import java.math.BigDecimal;

public class RealizaConversao {
    public void realizarConversao(BuscaValor buscaValor, String base, String destino, String nomeBase, String nomeDestino, BigDecimal valorPraConverter) {
        try {
            Moedas resultado = buscaValor.buscaValor(base);
            BigDecimal taxaDeCambio = resultado.conversion_rates().get(destino);

            Calculadora calculadora = new Calculadora();
            BigDecimal valorFinal = calculadora.conversor(taxaDeCambio, valorPraConverter);

            System.out.println(valorPraConverter + " " + nomeBase + " = " + valorFinal + " " + nomeDestino + ".");
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao buscar a taxa de câmbio: " + e.getMessage());
        }
    }
}
