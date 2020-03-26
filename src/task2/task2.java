package task2;


import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        double a;
        int i = 0;
        String otr, chet;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите целое число: ");
            a = in.nextDouble();
            i++;
            if ((a - (int) a) != 0) {
                if (i < 5) {
                    System.out.println("Введено дробное число, введите число еще раз. У вас осталось " + (5 - i) + " попыток.");
                } else {
                    System.out.println("Вы исчерпали количество попыток");
                    System.exit(0);
                }
            }
        } while ((a-(int)a) != 0);
        if (a == 0){
            System.out.println("Введено нулевое значение.");
        } else {
            if (a>0) {
                otr = "положительное";
            }else {
                otr = "отрицательное";
            }
            if ((a/2)-(int)(a/2) == 0){
                chet = "четное";
            }else {
                chet = "не четное";
            }
            System.out.print("Введенное число "+otr+" и "+chet);
        }
    }
}
