package homework15;

import java.io.File;
import java.util.Scanner;

class Dir {
    public void listDir(String way, int l, int c) throws NullPointerException{
        if (l>-1){
            File[] list;
            list = new File(way).listFiles();
            try {
                for (int i=0;i<list.length;i++){
                    PrintNam.printNam(list[i].toString().substring(list[i].toString().lastIndexOf("\\")),c);
                    task1.calc+=1;
                    if (list[i].isDirectory()) {
                    listDir(list[i].toString(),(l-1), c+1);
                    }
                }
                } catch (NullPointerException e){
                    PrintNam.printNam("Объект является ссылкой.",c);
                }
        }
    }
   public void listDir(String way, int c) throws NullPointerException{
            File[] list;
            list = new File(way).listFiles();
            try {
                for (int i=0;i<list.length;i++){
                    PrintNam.printNam(list[i].toString().substring(list[i].toString().lastIndexOf("\\")),c);
                    task1.calc+=1;
                    if (list[i].isDirectory()) {
                        listDir(list[i].toString(),c+1);
                    }
                }
            } catch (NullPointerException e){
                PrintNam.printNam("Объект является ссылкой.",c);
            }
        }
    }

class PrintNam {
    public static void printNam(String list, int c){
        for (int ii=0; ii<c;ii++){
            System.out.print(" ");
        }
        System.out.println(list);
    }
}


public class task1 {
    public static int calc;
    public static void main(String[] args) {
        Dir dir = new Dir();
        System.out.print("Введите путь к каталогу, обязательно в конце строки долженбыть \"\\\": ");
        String in = new Scanner(System.in).nextLine();
        System.out.print("Введите глубену вложенности,\nпри вводе -1 выводится все дерево каталогов с максимальной вложенностью: ");
        int l = new Scanner(System.in).nextInt();
        if(new File(in).listFiles() != null){
            if (l!=-1){
                dir.listDir(in,l,0);
                System.out.println("\n-------Всего выведено "+calc+" объектов.--------");
            }else {
                System.out.println("--------------- На будет осуществлен вывод всего дерева каталога "+in+". -------------------");
                dir.listDir(in,0);
                System.out.println("\n-------Всего выведено "+calc+" объектов.--------");
            }
        }else {
            PrintNam.printNam("Объект не найден.",0);
        }
    }
}
