package edu.gemini.delayedflight;

/**
 *
 * @author ASaburov
 */
public class Main {

    // При задержке на каждые 4 часа пассажира обязаны покормить.
    // Питание стоит LUNCH долларов
    private static final Integer LUNCH = 10;
    // При задержке более 12 часов каждого пассажира обязаны покормить и препроводить в комнату отдыха.
    // Отдых стоит REST долларов
    private static final Integer REST = 50;

    /**
     * Необходимо написать программу, которая считает количество денег,
     * потраченное для обслуживания всех пасажиров всех рейсов
     */
    public static void main(String[] args) {
        DelayedFlight[] df = DelayedFlight.getDelayedFlight();

        for(int i=0; i<df.length; i++) {
            System.out.println("DF:" + df[i]);
        }
    }

}
