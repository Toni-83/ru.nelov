package homework27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class IterationsMethod {
    public IterationsMethod(int in){
        int ii = 1;
        int a;
        for (int i = 0;i<=in;i=a){
            if (i!=0) System.out.print(", ");
            System.out.print(i);
            a=i+ii;
            ii=i;
        }
        System.out.println(".");
    }
}
class RecursionMethod {
    LinkedList link=new LinkedList();
    ArrayList list= new ArrayList();
    int i = 0;
    int ii = 1;
    int a = 0;
    public void recursionMethod(int in) {
        if (i>in){
            System.out.println(".");
            return;
        }
        if (i!=0) System.out.print(", ");
            System.out.print(i);
        a=i+ii;
        ii=i;
        i=a;

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
