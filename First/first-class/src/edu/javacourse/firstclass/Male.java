package edu.javacourse.firstclass;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class Male {

    String name;
    int age;
    int money;
    int savings;

    void goToWorkAndEarnSomeMoney() {
        System.out.println(name + " goes to work and earns 100$");
        money = money + 100;
    }

    void payTaxes() {
        System.out.println(name + " pays his taxes for 20$");
        money = money - 20;
    }

    int getAllMoney() {
        return money + savings;
    }

}
