package edu.gemini.taxpayer;

import edu.gemini.taxpayer.storage.TaxPayerStorage;

/**
 *
 * @author ASaburov
 */
public class Main {

    public static void main(String[] args) {
        TaxPayerStorage tps = new TaxPayerStorage();
        TaxPayer[] tpArray = tps.getTaxPayers();

        for(TaxPayer tp : tpArray) {
            System.out.println(tp.getInfo());
        }
    }

}
