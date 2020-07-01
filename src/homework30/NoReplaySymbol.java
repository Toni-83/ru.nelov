package homework30;

import java.util.List;
import java.util.Scanner;

public class NoReplaySymbol {
    static Scanner in = new Scanner(System.in);
    static String str;
    static List <Character> list;
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        str = in.nextLine();
        for (char iter : str.toCharArray()) {
            if (str.indexOf(iter, 1) > 0) {
                str = str.replaceAll(String.valueOf(iter), "");
            } else {
                System.out.println(str.charAt(0));
                break;
            }
        }
        System.out.println("Конец.");
    }
}
