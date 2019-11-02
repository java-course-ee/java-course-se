package edu.javacourse.firstclass;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class Female {

    String name;
    int age;
    int money;

    void goToMallAndSpendSomeMoney() {
        System.out.println(name + " goes to mall to spend 200$");
        money = money - 200;
    }

    int getMoney() {
        return money;
    }

}
