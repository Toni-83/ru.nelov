package homework21;

import java.util.Arrays;

public class task2 {
    static int[] data = {1,2,3,4,5,6,7,8,9};
    public static void main(String[] args){
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(data).replace("[","").replace("]","")+".");
        System.out.println("");
        for (int i=0; i<(data.length/2);i++) {
            int a = data[i];
            data[i]=data[data.length-(i+1)];
            data[data.length-(i+1)] = a;
        }
        System.out.print("Измененный массив: ");
        System.out.println(Arrays.toString(data).replace("[","").replace("]","")+".");
    }
}
