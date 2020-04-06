package homework7;

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
                System.out.println((i+1)+". "+napitoks[i].name+ " price: "+napitoks[i].price+" RUB.");
            }
        }
    }
}
class Choice {
    PriceList priceList = new PriceList();
    int cash;
    int choice;
    Scanner in = new Scanner(System.in);
    public void choice(){
        priceList.printPriceList();
        System.out.println("Enter amount: ");
        cash = in.nextInt();
        System.out.println("Enter a number of a drink, ore 0 to exit: ");
        choice = in.nextInt();
        while (( choice <= 0 || 10 <= choice) || priceList.napitoks[choice-1] == null){
            System.out.println("You enter wrong number of a drink.");
            priceList.printPriceList();
            System.out.println ("Please choice again, ore enter 0 to exit: ");
            choice=in.nextInt();
        }
    }
}
class Verification {
    Choice choice = new Choice();
    int summ = 0;
    int price = 0;
    public void verification (){
        choice.choice();
        summ = choice.cash;
        while (choice.choice != 0 && summ < choice.priceList.napitoks[choice.choice-1].price) {
            price = choice.priceList.napitoks[choice.choice - 1].price;
            System.out.println("Not enough money, you need to replenish for "+ (price - summ) + " RUB.");
                choice.choice();
                summ = summ + choice.cash;

        }
        System.out.println("Thank you for your purchase. Pick up change: "+ (summ-price) +" .");
    }
}
public class task1 {
    public static void main(String[] args) {
        Verification verification = new Verification();
        verification.verification();

    }
}
