package homework31;

import java.util.Scanner;

class PalendromString2 {
    Scanner in = new Scanner(System.in);
    String str;
    public void verification2 (){
        System.out.print("Введите строку: ");
        str = in.nextLine();
        StringBuffer stringBuffer = new StringBuffer (str);
        if (stringBuffer.reverse().toString().equals(str)) System.out.println("Строка: "+str+" является палиндромом");
        else System.out.println("Строка: "+str+" не является палиндромом");
    }
}

public class Palendrom2 {
    public static void main(String[] args) {
        PalendromString2 pal = new PalendromString2();
        pal.verification2();
    }
}
