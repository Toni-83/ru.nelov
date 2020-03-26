package homework4;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n, rpog = 0;
        do {
        System.out.println(" ");
        n = in.nextDouble();
        } while ((n-(int)n) != 0 | rpog<1 | rpog>2);
    }
}
