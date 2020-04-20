package homework13;

import java.lang.reflect.Array;
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
    public FoodIsBad(String massage){
        super(massage);
    }
}
class Child{
    void childtaste(String food) throws FoodIsBad {
        try {
            if (Arrays.toString(ChildLiceFood.values()).toLowerCase().contains(food.toLowerCase()) == true) {
                System.out.println("Мне понравилось, я очень люблю "+food+".");
            }else {
                throw new FoodIsBad("Ребенок не любит "+food+".");
            }

        } catch (FoodIsBad e) {
            throw e;
        } finally{
             System.out.println("Спасибо Мамочка.");
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
            System.out.println("Мама похвалила ребенка.");
        } catch (FoodIsBad e) {
        System.out.println("Мама расстроина из-за испорченного настроения ребенак: "+e.getMessage());
        }

    }
}
