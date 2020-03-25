package task1;

import java.util.Scanner;



public class task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b;
        System.out.print("введите первое число: ");
        a = in.nextInt();
        System.out.print("введите второе число: ");
        b = in.nextInt();
        System.out.println("первое число = "+a);
        System.out.println("второе число = "+b);
        b=a-b;
        System.out.println("разница" + b);
    }
}
