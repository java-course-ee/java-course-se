package edu.javacourse.firstclass;

public class Main {

    public static void main(String[] args) {

        Male m1 = new Male();
        m1.name = "Ivan";
        m1.age = 30;
        m1.money = 500;
        m1.savings = 5000;

        Male m2 = new Male();
        m2.name = "Petr";
        m2.age = 45;
        m2.money = 300;
        m2.savings = 1000;


        Female f1 = new Female();
        f1.name = "Marfa";
        f1.age = 25;
        f1.money = 1000;
        f1.savings = 100;

        Female f2 = new Female();
        f2.name = "Pelageya";
        f2.age = 29;
        f2.money = 650;
        f2.savings = 200;


        m1.goToWorkAndEarnSomeMoney();
        m1.goToWorkAndEarnSomeMoney();
        m1.payTaxes();
        System.out.println(m1.name + "'s current money: " + m1.getAllMoney());
        System.out.println();

        m2.payTaxes();
        System.out.println(m2.name + "'s current money: " + m2.getAllMoney());
        System.out.println();

        f1.goToMallAndSpendSomeMoney();
        f1.goToMallAndSpendSomeMoney();
        System.out.println(f1.name + "'s current money: " + f1.getAllMoney());
        System.out.println();

        f2.goToMallAndSpendSomeMoney();
        System.out.println(f2.name + "'s current money: " + f2.getAllMoney());
        System.out.println();


    }

}
