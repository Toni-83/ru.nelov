package homework25;


import java.util.Collections;
import java.util.HashMap;

import java.util.Map;

class IsUnique{
    public boolean isUnique(Map<String, String> map){
        boolean res = true;
        for (String iter: map.values()) if (Collections.frequency(map.values(),iter)>1) res = false;
        return res;
    }
}

public class Unique {
    static Map<String,String> prodMap = new HashMap<>();
    static IsUnique isUnique = new IsUnique();
    public static void main(String[] args){
        prodMap.put("Вася","Иванов");
        prodMap.put("Петр","Петров");
        prodMap.put("Виктор","Сидоров");
        prodMap.put("Сергей","Савельев");
        prodMap.put("Вадим","Викторов");
        prodMap.put("Иван","Петров");
        System.out.println("Результат: " + isUnique.isUnique(prodMap));
    }
}
