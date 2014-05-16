package edu.gemini.taxpayer;

/**
 *
 * @author ASaburov
 */
public class Person implements TaxPayer {

    public static final int MAX_INCOME = 100000;
    public static final int TAX_RATE = 13;
    //
    private Double income;
    private Double payedTax;

    public Person() {
        income = Math.random() * MAX_INCOME;
        // Надо обратить внимание на то, что при операции с двумя разными типами
        // приведение идет к "наибольшему"
        payedTax = Math.random() * MAX_INCOME * TAX_RATE / 100.0;
    }

    public Double getIncome() {
        return income;
    }

    public Double getPayedTax() {
        return payedTax;
    }

    public String getInfo() {
        return "Person: Income=" + getIncome() + " Tax=" + getPayedTax();
    }
}
