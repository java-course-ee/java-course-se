package edu.gemini.aimer;

/**
 *
 */
public class AimFactory {

    /**
     * Метод создает массив целей от 5 до 10 штук с координатами
     * X - от 15000 до 25000 метров
     * Y - от 15000 до 25000 метров
     * Скорость - от 300 до 700 метров в секунду
     *
     */
    public static Aim[] getAimList() {
        Integer count = (int) Math.round(Math.random() * 5) + 5;
        Aim[] aim = new Aim[count];

        for (int i = 0; i < aim.length; i++) {
            Integer x = (int) Math.round(Math.random() * 10000) + 15000;
            Integer y = (int) Math.round(Math.random() * 10000) + 15000;
            Integer speed = (int) Math.round(Math.random() * 400) + 300;
            aim[i] = new Aim(x, y, speed);
        }

        return aim;
    }
}
