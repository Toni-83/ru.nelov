package homework24;

import java.util.HashSet;
import java.util.Set;

class OddArray {
    public Set<String> setArray(Set<String> set){
        set.removeIf(s -> s.toString().length() % 2 == 0);
        return set;
    }
}

public class OddElements {
    static Set<String> setStr = new HashSet<String>();
    static OddArray steOddArray = new OddArray();
    public static void main(String[] args){
        setStr.add("foo");
        setStr.add("buzz");
        setStr.add("bar");
        setStr.add("fork");
        setStr.add("bort");
        setStr.add("spoon");
        setStr.add("!");
        setStr.add("dude");
        setStr = steOddArray.setArray(setStr);
        System.out.println(setStr.toString());


    }
}
