package task1;

import java.util.Scanner;



public class task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a,b;
        int i=0;
        do {
            System.out.print("Введите первое целое число: ");
            a = in.nextDouble();
            i++;
            if ((a-(int)a) != 0)  {
                if (i<5){
                    System.out.println("Введено дробное число, введите число еще раз. У вас осталось " + (5-i) + " попыток.");
                } else {
                        System.out.println("Вы исчерпали количество попыток");
                        System.exit(0);
                }
            }
        } while ((a-(int)a) != 0);
        i=0;
        do {
            System.out.print("Введите первое целое число: ");
            b = in.nextDouble();
            i++;
            if ((b-(int)b) != 0)  {
                if (i<5) {
                    System.out.println("Введено дробное число, введите число еще раз. У вас осталось " + (5 - i) + " попыток.");
                } else {
                        System.out.println("Вы исчерпали количество попыток");
                        System.exit(0);
                }
            }
        } while ((b-(int)b) != 0);
        if (a<b) {
            System.out.println("Минимальное число = "+(int)a);
        }
        else {
            if (a==b) {
                System.out.println("Введены равные числа и равны значению "+(int)b);
            }
            else {
                System.out.println("Минимальное число = "+(int)b);
            }
        }
        System.out.println("первое число = "+(int)a);
        System.out.println("второе число = "+(int)b);
    }
}
