package edu.gemini.delayedflight;

/**
 * Класс описывает рейс. В нем указывается количество пассажиров и
 * насколько задержался данный рейс (в часах)
 *
 * @author ASaburov
 */
public class DelayedFlight {

    // Идентификатор полета/рейса - просто для информации - дожен быть уникальным
    private Integer flightId;
    // На сколько часов опоздал вылет
    private Integer delayedHours;
    // Количество пассажиров
    private Integer passangerAmount;

    public DelayedFlight(Integer fligthId, Integer delayedHours, Integer passangerAmount) {
        this.flightId = fligthId;
        this.delayedHours = delayedHours;
        this.passangerAmount = passangerAmount;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public Integer getDelayedHours() {
        return delayedHours;
    }

    public Integer getPassangerAmount() {
        return passangerAmount;
    }

    // Возвращает массив от 90 до 110 рейсов
    public static DelayedFlight[] getDelayedFlight() {
        Integer count = (int) Math.round(Math.random() * 20) + 90;
        DelayedFlight[] df = new DelayedFlight[count];

        for (int i = 0; i < df.length; i++) {
            Integer hour = (int) Math.round(Math.random() * 20);
            Integer passangers = (int) Math.round(Math.random() * 50) + 100;
            df[i] = new DelayedFlight(i, hour, passangers);
        }

        return df;
    }

    @Override
    public String toString() {
        return "Flight:" + flightId + " Hours:" + delayedHours + " Passangers:" + passangerAmount;
    }
}
