package edu.javacourse.firstclass;

public class Main {

    public static void main(String[] args) {

        Male m = new Male();
        m.name = "Ivan";
        m.age = 30;

        Female f = new Female();
        f.name = "Marfa";
        f.age = 25;

        m.goToWork();
        f.goToShop();

        System.out.println("Money left: " + m.howMuchMoneyDoYouHave());
        System.out.println("Money spent: " + f.spentMoney());

    }

}
