package homework31;

import java.util.Scanner;

class PalindromString1 {
    Scanner in = new Scanner(System.in);
    String str;
    boolean result = false;
    public void verification () {
        System.out.print("Введите строку: ");
        str = in.nextLine();
        for (int i = 0; i<(str.length()/2);i++) if (str.charAt(i)!=str.charAt(str.length()-1-i)) break;
        else result = true;
        if (result) System.out.println("Строка: "+str+" является палиндромом.");
        else System.out.println("Строка: "+str+" не является палиндромом.");
    }
}

public class Palindrom1 {
    public static void main(String[] args) {
        PalindromString1 pal = new PalindromString1();
        pal.verification();
    }
}
