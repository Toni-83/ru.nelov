package homework19;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;


class ReceiptOutFiles{
    LinkedList<String> outarray = new LinkedList<>();
    double sum = 0;
    String name = null;
    public boolean createReceiptFile(File fileIn, File fileOut) throws IOException {
        if (!fileOut.canExecute()){
            try (BufferedReader ins = new BufferedReader(new FileReader(fileIn));
                 BufferedWriter ouf = new BufferedWriter(new FileWriter(fileOut))) {
                while ((name =  ins.readLine())!=null){
                    double aDouble=0;
                    int aInt=0;
                    double cost = 0;
                    double costs = 0;
                    for (int i = 0; i<2;i++){
                        if (i==0){
                            aDouble = Double.parseDouble(ins.readLine());
                            if((aDouble-(int)aDouble)==0) aInt = (int)aDouble;
                        }
                        if (i==1) cost = Double.parseDouble(ins.readLine());
                    }
                    sum+=costs;
                    if (aInt!=0){
                        Formatter f = new Formatter().format("%1$-18s%2$6.2f x %3$6d%4$14s\n",name,cost,aInt,"="+Double.toString(costs));
                        outarray.add(f.toString());
                    }else {
                        Formatter f = new Formatter().format("%1$-18s%2$6.2f x %3$6.3f%4$14s\n",name,cost,aDouble,"="+Double.toString(costs));
                        outarray.add(f.toString());
                    }
                }
                ouf.write(new Formatter().format("%1$-18s%2$6s   %3$6s%4$14s","Наименование","Цена","Кол-во","Стоимость\n").toString());
                ouf.write("===============================================\n");
                for (String b:outarray){
                    ouf.write(b);
                }
                ouf.write("===============================================\n");
                ouf.write(new Formatter().format("%1$-18s%2$29.2f\n","Итого:",sum).toString());
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
