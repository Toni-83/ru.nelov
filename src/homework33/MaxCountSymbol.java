package homework33;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CountSymbol {
    Scanner in = new Scanner(System.in);
    String st;
    Map<Character, Integer> sm = new HashMap<>();
    public void inputString () {
        System.out.print("Введите текст: ");
        st = in.nextLine();
        sm.put(st.charAt(0), 1);
        for (int i=1; i < st.length(); i++){
            if (sm.containsKey(st.charAt(i))) {
                sm.put(st.charAt(i),(sm.get(st.charAt(i))+1));
            }
            else sm.put(st.charAt(i),1);
        }
    }
    public void printResult () {
        for(Map.Entry<Character,Integer> entry : sm.entrySet()) if (entry.getValue() == Collections.max(sm.values()))
            System.out.println(entry.getKey()+"="+entry.getValue());
        System.out.println("Конец.");
    }
}


public class MaxCountSymbol {
    public static void main(String[] args) {
        CountSymbol count = new CountSymbol();
        count.inputString();
        count.printResult();
    }
}
