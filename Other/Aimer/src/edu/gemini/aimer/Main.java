package edu.gemini.aimer;

/**
 *
 * @author ASaburov
 */
public class Main {

    /**
     * Написать программу для находения цели, которая быстрее всех
     * достигнет точки с координатами X=0, Y=0
     * Считаем, что все цели стремятся к этой точке по прямой.
     */
    public static void main(String[] args) {
        Aim[] aim = AimFactory.getAimList();

        for(int i=0; i<aim.length; i++) {
            System.out.println("Aim:" + aim[i]);
        }
    }

}
