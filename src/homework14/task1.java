package homework14;
import java.io.IOException;
import java.util.logging.*;
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
    private final static Logger L = Logger.getGlobal();
    public void PriceList(){
        napitoks[0]= new Napitok("Kolla", 2);
        napitoks[1]= new Napitok("Coffe", 3);

        for (int i=0; i<napitoks.length;i++) {
            if (napitoks[i]!= null){
                System.out.println((i+1)+". "+napitoks[i].name+ " price: "+napitoks[i].price+" RUB.");
                L.log(Level.INFO,"Вывод перечня напитков на экран");
            }
        }
    }
}

class Choice {
    int cash;
    int choice;
    Scanner in = new Scanner(System.in);
    private final static Logger L = Logger.getGlobal();
    public void Choice(PriceList priceList) {
        Choice ch;
        System.out.println("Enter amount: ");
        cash = in.nextInt();
        L.log(Level.INFO,"Внесли деньги: "+cash);
        System.out.println("Enter a number of a drink, ore 0 to exit: ");
        choice = in.nextInt();
        L.log(Level.INFO,"Выбран напиток под номером: "+choice);
        while ((choice < 0 || choice >= 10) || (choice != 0 && priceList.napitoks[choice - 1] == null)) {
            L.log(Level.SEVERE,"Пользоавтель ошибся и производит выбор напитка повторно.");
            System.out.println("You enter wrong number of a drink.");
            priceList.PriceList();
            System.out.println("Please choice again, ore enter 0 to exit: ");
            choice = in.nextInt();
            L.log(Level.INFO,"Пользователь повторно выбирает напиток, выбран номер: "+choice);
        }
    }
}

class Verification {
    int summ = 0;
    int price = 0;
    private final static Logger L = Logger.getGlobal();
    public void verification (PriceList priceList, Choice choice) {
        L.log(Level.INFO,"Проверка выбора.");
        if (choice.choice == 0) {
            System.out.println("Thank you for your purchase. Pick up change: " + (choice.cash) + " .");
            L.log(Level.INFO,"Напиток выдан, сдача выдана.");
            System.exit(0);
        }
        summ = choice.cash;
        price = priceList.napitoks[choice.choice - 1].price;
        while (summ < price) {
            L.log(Level.SEVERE,"Пользователю не хватает денег. Внесена сумма: "+summ+", выбран напиток под № "+choice.choice+".");
            System.out.println("Not enough money, you need to replenish for " + (price - summ) + " RUB.");
            choice.Choice(priceList);
            summ = summ + choice.cash;
            L.log(Level.INFO,"Внесена недостающая сумма: "+choice.cash);
            if (choice.choice == 0) {
                System.out.println("Thank you for your purchase. Pick up change: " + (summ) + " .");
                L.log(Level.FINEST,"Программа прервана пользователем, деньги выданы.");
                System.exit(0);
            }

        }
        System.out.println("Thank you for your purchase. Pick up change: " + (summ - price) + " .");
        L.log(Level.INFO,"Напиток выдан, сдача выдана.");
    }
}

public class task1 {
    //Создание глобального объекта для его дальнейшего использования в программе.
    private final static Logger Logr= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        LogManager.getLogManager().reset(); //Сброс настроек менеджера логирования.
        Logr.setLevel(Level.ALL); //Определение уровня собираемых логов.
        try {
            //При логировании в фай обязательна конструкция try-catch
            //Определение файла в который помещаются логи
            FileHandler fhUserError = new FileHandler("UerError.log");
            fhUserError.setLevel(Level.SEVERE); //Определение уровня логов помещаемых в файл
            fhUserError.setFormatter(new SimpleFormatter());//Задание стандартного формата лога, по умолчанию сохраняется в XML.
            Logr.addHandler(fhUserError);//Направление потока логов в созданный handler (перехватчик).

        } catch (IOException eUser) {
            System.err.println("File logger is not working"+ eUser.getMessage());
        }
        try {
            FileHandler fhInfo = new FileHandler("logInfo.log");
            fhInfo.setLevel(Level.INFO);
            fhInfo.setFormatter(new SimpleFormatter());
            Logr.addHandler(fhInfo);

        }catch (IOException eInfo) {
            System.err.println("File logger is not working"+ eInfo.getMessage());
        }
        try {
            FileHandler fhProgrammError = new FileHandler("logError.log");
            fhProgrammError.setLevel(Level.FINEST);
            fhProgrammError.setFormatter(new SimpleFormatter());
            Logr.addHandler(fhProgrammError);

        }catch (IOException eError) {
            System.err.println("File logger is not working"+ eError.getMessage());
        }

        Logr.log(Level.INFO,"Программа запущена.");
        PriceList priceList = new PriceList();
        Choice choice = new Choice();
        Verification verification= new Verification();
        priceList.PriceList();
        choice.Choice(priceList);
        verification.verification(priceList,choice);
        Logr.log(Level.INFO,"программа завершена успешно.");
    }
}