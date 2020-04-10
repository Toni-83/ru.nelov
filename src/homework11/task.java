package homework11;

import java.util.Scanner;

class Censor {
    public String Censor(String text) {
        String t = text.replaceAll("бяка","вырезано цензурой");
        return t;

    }
}

public class task {
    static String text;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Введите текст");
        text=in.nextLine();
        System.out.println(new Censor().Censor(text));
    }
}
