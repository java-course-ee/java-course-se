package edu.gemini.aimer;

/**
 *
 * @author ASaburov
 */
public class Aim {

    // Координата цели по оси X
    private Integer x;
    // Координата цели по оси Y
    private Integer y;
    // Скорость цели
    private Integer speed;

    public Aim(Integer x, Integer y, Integer speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y + " Speed:" + speed;
    }


}
