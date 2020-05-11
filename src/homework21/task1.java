package homework21;

import java.util.Arrays;

public class task1 {
    static int[] data = {1,2,3,4,5,6,7,8,9,10};
    public static void main(String[] args){
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(data).replace("[","").replace("]","")+".");
        System.out.println("");
        for (int i=0; (i+1)<data.length;i++) {
            data[i]=data[i+1];
            data[i+1]=0;
        }
        System.out.print("Измененный массив: ");
        System.out.println(Arrays.toString(data).replace("[","").replace("]","")+".");
    }
}
