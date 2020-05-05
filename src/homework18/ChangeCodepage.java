package homework18;

import java.io.*;
import java.util.Scanner;

class Converter{
    private final static int BUFFER_SIZE = 1000;
    public boolean Converter(File fileIn, File fileOut, String charsetf) throws IOException{
        if (!fileOut.canExecute()){
            try ( FileInputStream in = new FileInputStream(fileIn);
                  InputStreamReader ins = new InputStreamReader(in,new InputStreamReader(in).getEncoding());
                  FileOutputStream ou = new FileOutputStream(fileOut);
                  OutputStreamWriter ouf = new OutputStreamWriter(ou,charsetf)){
                System.out.println("Файл "+fileIn+" прочитан в кодировке "+new InputStreamReader(in).getEncoding()+".");
                    char[] buffer = new char[BUFFER_SIZE];
                    int readed;
                    while ((readed = ins.read(buffer,0,BUFFER_SIZE))>0)
                        ouf.write(buffer,0,readed);
                    return true;

            }
    }else return false;
    }
}

public class ChangeCodepage {
    public static void main(String[] args) throws IOException{
        System.out.println("Программя для изменения кодовой страници или кодировки файла.\n" +
                "Для выхода из программы просто введите Exit.");
        while (true){
            boolean res;
            Converter converter = new Converter();
            Scanner in = new Scanner(System.in);
            System.out.print("Введите полный путь к файлу: ");
            String way = in.nextLine();
            if (way.equalsIgnoreCase("exit")) break;
            File fileIn = new File(way);
            File fileOut;
            System.out.print("Выберите кодировку.\n" +
                    "Введите 1 для кодировки Windows PC-1251.\n" +
                    "Введите 2 для кодировки UTF8\n" +
                    "Введите 3 для кодировки CP-866.\n" +
                    "Ваш выбор: ");
            String choice = in.nextLine();
            try {
            if (choice.equalsIgnoreCase("exit")) break;
            switch (Integer.parseInt(choice)){
                case 1:
                    res = new Converter().Converter(fileIn, (fileOut=new File(way.replaceAll("\\.","CP-1251."))),"CP1251");
                    if(!res) {
                        System.out.println("Файл "+fileOut+" уже существует, удалите или переместите его.");
                    }else {
                        System.out.println("Файл "+fileOut+" успешно создан.");
                    }
                    break;
                case 2:
                    res = new Converter().Converter(fileIn, (fileOut=new File(way.replaceAll("\\.","UTF8."))),"UTF8");
                    if(!res) {
                        System.out.println("Файл "+fileOut+" уже существует, удалите или переместите его.");
                    }else {
                        System.out.println("Файл "+fileOut+" успешно создан.");
                    }
                    break;
                case 3:
                    res = new Converter().Converter(fileIn, (fileOut=new File(way.replaceAll("\\.","CP-866."))),"CP866");
                    if(!res) {
                        System.out.println("Файл "+fileOut+" уже существует, удалите или переместите его.");
                    }else {
                        System.out.println("Файл "+fileOut+" успешно создан.");
                    }
                    break;
                default :
                    System.out.println("Значение введено не верно, попробуйте снова");
                    break;
                    }
            }catch (EOFException e){
                System.out.println("Файл не найден, проверьте правильно ли указан путь и поробуйте снова.");
            }
        }
    }
}
