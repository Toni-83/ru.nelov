package homework3;

import java.util.Scanner;

class Napitok {
    String name;
    int price;

    public Napitok (String inputname, int inputprice){
        this.name=inputname;
        this.price=inputprice;
    }
}
class PriceList {
    Napitok[] napitoks = new Napitok[10];
    public void printPriceList (){
        napitoks[0]= new Napitok("Kolla", 2);
        napitoks[1]= new Napitok("Coffe", 3);
        for (int i=0; i<napitoks.length;i++) {
            if (napitoks[i]!= null){
                System.out.println((i+1)+". "+napitoks[i].name+ " price: "+napitoks[i].price);
            }
        }
    }
}
class Choice {
    int cash;
    int choice;
    Scanner in = new Scanner(System.in);
    public void choice(){
        System.out.println("Enter amount: ");
        cash = in.nextInt();
        System.out.println("Enter a number of a drink: ");
        choice = in.nextInt();
    }
}
class Verification {
    PriceList priceList = new PriceList();
    Choice choice = new Choice();
    int summ = 0;
    public void verification (){
        priceList.printPriceList();
        choice.choice();
        summ = choice.cash;
        while (choice.choice != 0 && summ != priceList.napitoks[choice.choice-1].price) {
            System.out.println("clr");
            priceList.printPriceList();
            System.out.println("Not enough money, you need to replenish for "
                    +(priceList.napitoks[choice.choice -1].price - summ) + " RUB." );
            choice.choice();
            summ = summ + choice.cash;
        }
        System.out.println("Thank you for your purchase. Pick up change.");
    }
}
public class task3 {
    public static void main(String[] args){
        Verification verification = new Verification();
        verification.verification();

    }
}
