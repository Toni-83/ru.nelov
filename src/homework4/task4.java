package homework4;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n, prog;
        int i = 0;
        do {
            System.out.print("Введите положительное целое число N: ");
            n = in.nextDouble();
            i++;
            if ((n-(int)n) != 0 | n<0)  {
                if (i<5){
                    System.out.println("Введено дробное число, введите число еще раз. У вас осталось " + (5-i) + " попыток.");
                } else {
                    System.out.println("Вы исчерпали количество попыток");
                    System.exit(0);
                }
            }
        } while ((n-(int)n) != 0 | n<0);
        i=0;
        do {
            System.out.print("Введите число 1 если требуется расчитать арифметическую прогрессию\nчисло 2 - если геометрическую прогрессию: ");
            prog = in.nextDouble();
            i++;
            if ((prog-(int)prog) != 0 | prog < 1 | prog > 2)  {
                if (i<5) {
                    System.out.println("Введено неверное значение, введите значение еще раз. У вас осталось " + (5 - i) + " попыток.");
                } else {
                    System.out.println("Вы исчерпали количество попыток");
                    System.exit(0);
                }
            }
        } while ((prog-(int)prog) != 0 | prog < 1 | prog > 2);
        if (prog == 1) {
            System.out.println("Выведена арифметическая прогрессия числа " + (int)n+":");
            for (int a=0;a<=n;a++) {
                System.out.println((int)n+a);
            }
        } else {
            System.out.println("Выведена геометрическая прогрессия числа " + (int)n+":");
            for (int a=1;a<=n;a++) {
                System.out.println((int)n*a);
            }
        }
    }
}
