package machine;

import java.util.Scanner;

class CoffeeMachine {
    int remainWater = 400;
    int remainMilk = 540;
    int remainCF = 120;
    int remainMoney = 550;
    int remainCups = 9;
    Scanner scan =new Scanner(System.in);

    void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(this.remainWater + " ml of water");
        System.out.println(this.remainMilk + " ml of milk");
        System.out.println(this.remainCF + " g of coffee beans");
        System.out.println(this.remainCups + " disposable cups");
        System.out.println("$" + this.remainMoney + " of money");
    }

    void CheckEnough(int a, int b, int c, int d) {
        if (remainWater >= a && remainMilk >= b && remainCF >= c && remainCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            remainWater -= a;
            remainMilk -= b;
            remainCF -= c;
            remainCups -= 1;
            remainMoney += d;
        } else {
            if (remainWater < a) System.out.println("Sorry, not enough water!");
            if (remainMilk < b) System.out.println("Sorry, not enough milk!");
            if (remainCF < c) System.out.println("Sorry, not enough coffee beans!");
            if (remainCups < 1) System.out.println("Sorry, not enough disposable cup");
        }
    }



    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String userChoice = scan.nextLine();
        switch(userChoice) {
            case "1":
                CheckEnough(250, 0, 16, 4);
                break;
            case "2":
                CheckEnough(350, 75, 20, 7);
                break;
            case "3":
                CheckEnough(200, 100, 12, 6);
                break;
            case "back":
                break;
        }
    }

    void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        remainWater += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        remainMilk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        remainCF += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add");
        remainCups += scan.nextInt();
        scan.nextLine();
    }

    void take() {
        System.out.println("I gave you $" + remainMoney);
        remainMoney = 0;
    }

    void WriteAction() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String choice = scan.nextLine();
            switch (choice) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    isContinue = false;
                    break;
                default:
                    break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.WriteAction();
    }
}
