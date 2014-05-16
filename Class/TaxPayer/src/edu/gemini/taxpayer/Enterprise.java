package edu.gemini.taxpayer;

/**
 *
 * @author ASaburov
 */
public class Enterprise implements TaxPayer {

    public static final int MAX_INCOME = 2000000;
    public static final int TAX_RATE = 35;
    //
    private Double[] income = new Double[12];
    private Double[] payedTax = new Double[12];

    public Enterprise() {
        for (int i = 0; i < income.length; i++) {
            income[i] = Math.random() * MAX_INCOME;
        }
        for (int i = 0; i < payedTax.length; i++) {
            payedTax[i] = Math.random() * MAX_INCOME * TAX_RATE/100.0;
        }
    }

    public Double getIncome() {
        Double sum = 0.0;
        for (Double d : income) {
            sum += d;
        }
        return sum;
    }

    public Double getPayedTax() {
        Double sum = 0.0;
        for (Double d : payedTax) {
            sum += d;
        }
        return sum;
    }

    public String getInfo() {
        return "Enterprise: Income=" + getIncome() + " Tax=" + getPayedTax();
    }
}
