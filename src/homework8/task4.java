package homework8;

import java.lang.reflect.Array;
import java.util.Date;

final class Contract {
    int number;
    String data;
    String[] priseList = {"Clock","Cap","Phone","Cam"};
    public Contract(){
        number++;
        data = new Date().toString();
    }
}

class Act {
    int number;
    String data;
    String[] product;

    public Act(String data, String[] product) {
        number++;
        this.data = data;
        this.product = product;
    }
}
class CreateAct{
        public static Act CreateAct(Contract contract){
            return new Act(contract.data,contract.priseList);
        }
}


public class task4 {
    public static void main(String[] args){

        Contract contract=new Contract();
        CreateAct act= new CreateAct();  //сразу не получилось проинициализировать и передать данные.?
        Act newAct = act.CreateAct(contract);
        System.out.println("Contract № " + contract.number + "\nDate: " +contract.data);
        printArray(contract.priseList);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Act № " + newAct.number + "\nDate: " +newAct.data);
        printArray(newAct.product);
    }

    private static void printArray(String[] product) {
        for (int i = 0; i < product.length; i++) {
            System.out.println(product[i] + " ");
        }
    }
}
