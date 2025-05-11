import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        BuscaValor buscaValor = new BuscaValor();
        List<String> boasVindas = List.of(
                "***********************************************",
                "Seja bem-vindo(a) ao Conversor de Moedas ;)",
                " ",
                "1) Dólar >>> Peso Argentino",
                "2) Peso Argentino >>> Dólar",
                "3) Dólar >>> Real Brasileiro",
                "4) Real Brasileiro >>> Dólar",
                "5) Dólar >>> Peso Colombiano",
                "6) Peso Colombiano >>> Dólar",
                "7) Sair",
                " ",
                "Escolha uma opção válida:",
                "***********************************************"
        );

        for (String linha : boasVindas) {
            System.out.println(linha);
        }

        int usuario = 0;
        BigDecimal valorPraConverter = BigDecimal.ZERO;

        do {
            System.out.println("\nEscolha uma opção ou digite 7 para sair:");

            while (!leitor.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, digite um número de 1 a 7.");
                leitor.next();
            }
            usuario = leitor.nextInt();

            if (usuario != 7) {
                System.out.println("Digite o valor que deseja converter:");

                while (!leitor.hasNextBigDecimal()) {
                    System.out.println("Entrada inválida! Por favor, digite um número decimal.");
                    leitor.next();
                }
                valorPraConverter = leitor.nextBigDecimal();
            }

            switch (usuario) {
                case 1:
                    realizarConversao(buscaValor, "USD", "ARS", "Dólares", "Pesos Argentinos", valorPraConverter);
                    break;
                case 2:
                    realizarConversao(buscaValor, "ARS", "USD", "Pesos Argentinos", "Dólares", valorPraConverter);
                    break;
                case 3:
                    realizarConversao(buscaValor, "USD", "BRL", "Dólares", "Reais", valorPraConverter);
                    break;
                case 4:
                    realizarConversao(buscaValor, "BRL", "USD", "Reais", "Dólares", valorPraConverter);
                    break;
                case 5:
                    realizarConversao(buscaValor, "USD", "COP", "Dólares", "Pesos Colombianos", valorPraConverter);
                    break;
                case 6:
                    realizarConversao(buscaValor, "COP", "USD", "Pesos Colombianos", "Dólares", valorPraConverter);
                    break;
                case 7:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (usuario != 7);
    }

    private static void realizarConversao(BuscaValor buscaValor, String base, String destino, String nomeBase, String nomeDestino, BigDecimal valorPraConverter) {
        try {
            Moedas resultado = buscaValor.buscaValor(base);
            BigDecimal taxaDeCambio = resultado.conversion_rates().get(destino);

            Calculadora calculadora = new Calculadora();
            BigDecimal valorFinal = calculadora.conversor(taxaDeCambio, valorPraConverter);

            System.out.println("1 " + nomeBase + " = " + taxaDeCambio + " " + nomeDestino + ".");
            System.out.println(valorPraConverter + " " + nomeBase + " = " + valorFinal + " " + nomeDestino + ".");
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao buscar a taxa de câmbio: " + e.getMessage());
        }
    }
}