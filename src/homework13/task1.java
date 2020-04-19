package homework13;

import java.util.Arrays;
import java.util.Scanner;

enum Food {
    CARROT ("Морковь"),
    ORANGE ("Апельсин"),
    CHOCOLATE ("Шоколад"),
    OATMEAL("Овсянка"),
    SOUP("Суп");
private String title;
    Food(String title) {
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString(){
        return title;
    }
}
enum ChildLiceFood{
    CARROT ("Морковь"),
    ORANGE ("Апельсин"),
    CHOCOLATE ("Шоколад");
    private String title;
    ChildLiceFood(String title) {
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString(){
        return title;
    }
}
class FoodIsBad extends Exception {
    String massage;
    public FoodIsBad(String massage){
        this.massage=massage;
    }
    @Override
    public String toString(){
        return massage;
    }
}
class Child{
    String childtaste(String food) throws FoodIsBad {
        try {
            for (int i = 0; i < ChildLiceFood.values().length; i++){
                if (food.toLowerCase().equals(ChildLiceFood.values()[i].toString().toLowerCase()) == true) {
                    System.out.println("Было очень вкусно.");
                }
            }
        } finally {
            throw new FoodIsBad("Спасибо Мамочка.");
        }
    }
}

public class task1 {
    public static void main(String[] args){
        System.out.println("Выберите чем Мама кормит ребенка "+Arrays.toString(Food.values()).replace("[","").replace("]","")+":");
        String in = new Scanner(System.in).nextLine();
        Child child = new Child();
        String test;
        try {
            child.childtaste(in);
        } catch (FoodIsBad foodIsBad) {
        System.out.println(foodIsBad);
        }

    }
}
