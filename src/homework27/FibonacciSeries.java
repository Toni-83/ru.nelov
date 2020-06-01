package homework27;

import java.util.Scanner;

class IterationsMethod {
    public IterationsMethod(int in){
        for (int i = 0;i<in;i+=i){
            if (i!=0) System.out.print(", ");
            System.out.print(i);
            if (i==0){
                i=1;
                System.out.print(", "+i);
            }
        }
        System.out.println(".");
    }
}
class RecursionMethod {
    int i = 0;
    public void recursionMethod(int in) {
        if (i>in){
            System.out.println(".");
            return;
        }
        if (i!=0) System.out.print(", ");
            System.out.print(i);
            i+=i;
        if (i==0){
            i=1;
        }
        this.recursionMethod(in);
    }
}

public class FibonacciSeries {
    static String in;
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Ряд Фибоначчи.");
        while (true){
            System.out.print("Введите 1 если требуется вывсти ряд Фибоначчи методом Итеррации или 2 для рекурсивного метода: ");
            in = s.nextLine();
            if (in.equalsIgnoreCase("exit")) return;
            switch (Integer.parseInt(in)){
                case 1:
                    System.out.print("\nВведите число до которого трбуется построить ряд Фибоначчи: ");
                    if ((in = s.nextLine()).equalsIgnoreCase("exit")) break;
                    new IterationsMethod(Integer.parseInt(in));
                    break;
                case 2:
                    System.out.print("\nВведите число до которого трбуется построить ряд Фибоначчи: ");
                    if ((in = s.nextLine()).equalsIgnoreCase("exit")) break;
                    new RecursionMethod().recursionMethod(Integer.parseInt(in));
                    break;
                default:
                    System.out.println("Введены неверные значения попробуйте еще раз.");
                    break;
            }
            if (in.equalsIgnoreCase("exit")) return;
        }
    }
}
