import java.math.BigDecimal;

public class Calculadora {
    public BigDecimal conversor(BigDecimal conversion_rates, BigDecimal valorPraConverter){
        return conversion_rates.multiply(valorPraConverter);
    }
}
