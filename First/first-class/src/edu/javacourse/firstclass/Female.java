package edu.javacourse.firstclass;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class Female {

    String name;
    int age;
    int money;
    int savings;

    void goToMallAndSpendSomeMoney() {
        System.out.println(name + " goes to mall to spend 200$");
        money = money - 200;
    }

    int getAllMoney() {
        return money + savings;
    }

}
