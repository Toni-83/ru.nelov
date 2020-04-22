package homework15;

import java.io.File;
import java.util.Scanner;

class Dir {
    int c =0;
    public void listDir(String way, int l) throws NullPointerException{
        if (l>-1){
            File[] list;
            list = new File(way).listFiles();
            try {
                for (int i=0;i<list.length;i++){
                    PrintDir.printDir(list[i].toString().substring(list[i].toString().lastIndexOf("\\")),c);
                    if (list[i].isDirectory()) {
                    listDir(list[i].toString(),(l-1),1);
                    }
                }
                } catch (NullPointerException e){
                    PrintDir.printDir("Объект не найден.",c);
                }
        }
    }
    private void listDir(String way, int l, int c) throws NullPointerException{
        if (l>-1){
            File[] list;
            list = new File(way).listFiles();
            try {
                for (int i=0;i<list.length;i++){
                    PrintDir.printDir(list[i].toString().substring(list[i].toString().lastIndexOf("\\")),c);
                    if (list[i].isDirectory()) {
                        listDir(list[i].toString(),(l-1),c+1);
                    }
                }
            } catch (NullPointerException e){
                PrintDir.printDir("Объект является ссылкой.",c);
            }
            }
        }
    }

class PrintDir{
    public static void printDir(String list, int c){
        for (int ii=0; ii<c;ii++){
            System.out.print(" ");
        }
        System.out.println(list);
    }
}

public class task1 {
    public static void main(String[] args) {
        Dir dir = new Dir();
        System.out.print("Введите путь к каталогу, обязательно в конце строки долженбыть \"\\\": ");
        String in = new Scanner(System.in).nextLine();
        System.out.print("Введите глубену вложенности: ");
        int l = new Scanner(System.in).nextInt();
        dir.listDir(in,l);
    }
}
