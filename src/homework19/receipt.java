package homework19;

import java.io.*;
import java.math.BigDecimal;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;


class ReceiptOutFiles{
    LinkedList<String> outarray = new LinkedList<>();
    double sum = 0;
    public boolean createReceiptFile(File fileIn, File fileOut) throws IOException {
        if (!fileOut.canExecute()){
            try (BufferedReader ins = new BufferedReader(new FileReader(fileIn));
                 BufferedWriter ouf = new BufferedWriter(new FileWriter(fileOut))) {
                while (ins.readLine()!=null){
                    String name = null;
                    double aDouble=0;
                    int aInt=0;
                    double cost = 0;
                    double costs = 0;
                    for (int i = 0; i<3;i++){
                        if (i==0) name = ins.readLine();
                        if (i==1){
                            aDouble = Double.parseDouble(ins.readLine().replace(".",","));
                            if((aDouble-(int)aDouble)==0) aInt = (int)aDouble;
                        }
                        if (i==2) cost = Double.parseDouble(ins.readLine().replace(".",","));
                    }
                    costs = new BigDecimal(Double.toString((aDouble*cost))).doubleValue();
                    sum+=costs;
                    if (aInt!=0){
                        outarray.add(new Formatter().format("%1$-18.18s%2$6.6f x %3$6.6d%4$14.14s",name,cost,aInt,"="+Double.toString(costs)).toString());
                    }else {
                        outarray.add(new Formatter().format("%1$-18.18s%2$6.6f x %3$6.6f%4$14.14s",name,cost,aDouble,"="+Double.toString(costs)).toString());
                    }
                }
                ouf.write(new Formatter().format("%1$-18.18s%2$6.6s   %3$6.6s%4$14.14s","Наименование","Цена","Кол-во","Стоимость").toString());
                ouf.write("===============================================");
                for (String b:outarray){
                    ouf.write(b);
                }
                ouf.write("===============================================");
                ouf.write(new Formatter().format("%1$-18.18s%2$29.29f","Итого:",sum).toString());
            }
        }else return false;
        return true;
    }
}

public class receipt {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Создание файла с чеком.\nДля выхода из программы введите Exit");
        while (true){
            System.out.print("Введите путь к входному файлу: ");
            String file = in.nextLine();
            if (file.equalsIgnoreCase("exit"))break;
            try {
                boolean rez = new ReceiptOutFiles().createReceiptFile(new File(file),new File(file.replaceAll(".txt","_out.txt")));
                if (rez){
                    System.out.println("Данные успешно обработаны, создан файл: "+file.replaceAll(".txt","_out.txt")+".");
                }else {
                    System.out.println("Данные сохранить не удалось, файл "+file.replaceAll(".txt","_out.txt")+
                            "уже существует, переместите его и попробуйте еще раз.");
                }
            }catch (IOException e){
                System.out.println("Файла "+file+" не существует, попробуйте еще раз.");
            }
        }
    }
}
