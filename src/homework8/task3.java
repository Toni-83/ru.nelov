package homework8;

// Подсчет запущенных экземпляров класса.
class MyCalc {
    private int calc;
    public MyCalc () {
        calc++;
    }
    public int getCalc() {
        return calc;
    }
}

public class task3 {
    public static void main(String[] args){
        MyCalc myCalc1 = new MyCalc();
        MyCalc myCalc2 = new MyCalc();
        MyCalc myCalc3 = new MyCalc();
        MyCalc myCalc4 = new MyCalc();
     System.out.println(new MyCalc().getCalc());
     System.out.println(new MyCalc().getCalc());
     System.out.println(new MyCalc().getCalc());
     System.out.println(new MyCalc().getCalc());
     System.out.println("------------------------------------------------------------------------");
        System.out.println(myCalc1.getCalc());
        System.out.println(myCalc2.getCalc());
        System.out.println(myCalc3.getCalc());
        System.out.println(myCalc4.getCalc());
    }
}
