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
    public void PriceList(){
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
    int cash;
    int choice;
    Scanner in = new Scanner(System.in);
    public void Choice(PriceList priceList) {
        Choice ch;
        System.out.println("Enter amount: ");
        cash = in.nextInt();
        System.out.println("Enter a number of a drink, ore 0 to exit: ");
        choice = in.nextInt();
        while ((choice < 0 || choice >= 10) || (choice != 0 && priceList.napitoks[choice - 1] == null)) {
            System.out.println("You enter wrong number of a drink.");
            priceList.PriceList();
            System.out.println("Please choice again, ore enter 0 to exit: ");
            choice = in.nextInt();
        }
    }
}

class Verification {
    int summ = 0;
    int price = 0;
    public void verification (PriceList priceList, Choice choice) {
        if (choice.choice == 0) {
            System.out.println("Thank you for your purchase. Pick up change: " + (choice.cash) + " .");
            System.exit(0);
        }
        summ = choice.cash;
        price = priceList.napitoks[choice.choice - 1].price;
        while (summ < price) {
            System.out.println("Not enough money, you need to replenish for " + (price - summ) + " RUB.");
            choice.Choice(priceList);
            summ = summ + choice.cash;
            if (choice.choice == 0) {
                System.out.println("Thank you for your purchase. Pick up change: " + (summ) + " .");
                System.exit(0);
            }

        }
        System.out.println("Thank you for your purchase. Pick up change: " + (summ - price) + " .");
    }
}
public class task1 {

    public static void main(String[] args) {
        PriceList priceList = new PriceList();
        Choice choice = new Choice();
        Verification verification= new Verification();
        priceList.PriceList();
        choice.Choice(priceList);
        verification.verification(priceList,choice);
    }
}
