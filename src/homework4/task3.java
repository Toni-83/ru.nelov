package homework4;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a;
        System.out.print("В ведите число от 1 до 10 для которого требуется вывести таблицу умножения. \n Число: ");
        int i = 0;
        do {
            a = in.nextDouble();
            i++;
            if (a<1 | (a-(int)a) != 0 | a>10) {
            if (i<5) {
                System.out.print("Введено неверное число, осуществите ввод еще раз. \n Число: ");
            }
            else {
                System.out.println("Вы привысили количество попыток, ввели ошибочное значение более 5 раз.");
                System.exit(0);
            }
            }
        } while ((a-(int)a) != 0 | a<1 | a>10);
            System.out.println("\n Умножение числа "+(int)a);
            for (int b=1; b<=10; b++){
                System.out.println((int)a+"*"+b+"="+(int)(a*b));
            }
    }
}
