package homework17;


import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

class Book implements Serializable{
    String name;
    String author;
    String data;
    public Book (String name, String author, String data){
        this.name=name;
        this.author=author;
        this.data=data;
    }
    public void book (String name, String author, String data){
        this.name=name;
        this.author=author;
        this.data=data;
    }
    public void printBook () {
        System.out.printf("Название книги: %s\nгод выпуска: %s\tавтор: %s.",name,author,data);
    }
}
class OutLibrary {
    public OutLibrary(Book book) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Library.txt"));
        out.writeObject(book);
        out.close();
    }
}
class InputLibrary {
    public void InputLibrary() throws ClassNotFoundException{
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Library.txt"));
            int ii=0;
            Scanner input = new Scanner(System.in);
            while (in.read()!=-1){
                for (int i = 0; i<5; i++) {
                    Book book = (Book) in.readObject();
                    System.out.print(i+1+ii);
                    book.printBook();
                }
                System.out.print("Нажмите Enter для продолжения вывода списка или любую клавишу для окончания.");
                if (input.next()!=null) break;
                ii+=5;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Файл библиотеки отсутствует.");
        }
    }
}
class ChangeLibrary {
    public ChangeLibrary() throws ClassNotFoundException{
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Library.txt"));
            int ii=0;
            Scanner input = new Scanner(System.in);
            while (in.read()!=-1){
                Book book = (Book) in.readObject();
                ii++;
                System.out.print(ii+". ");
                book.printBook();
                System.out.print("Нажмите Enter для продолжения вывода списка или любую клавишу для редактирования.");
                if (input.next()!=null) {
                    System.out.print("Введите название книги: ");
                    String name = input.nextLine();
                    System.out.print("Введите автора: ");
                    String author = input.nextLine();
                    System.out.print("Введите дату выпуска: ");
                    String data = input.nextLine();
                    book.book(name,author,data);
                    //new OutLibrary(new Book(name,author,data));
                    System.out.println("Редактирование завершено успешно");
                    break;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Файл библиотеки отсутствует.");
        }
    }
}


public class task1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        InputLibrary library = new InputLibrary();
        System.out.println("Домашняя библиотека.");
        int in;
        do {
            library.InputLibrary();
            System.out.print("Если хотите добавит книгу введите 1,\nесли редактировать существующую запись - нажмите 2\nили 0 для выхода из программы.");
            in = input.nextInt();
            if (in==1){
                System.out.println("Введите название книги: ");
                String name1 = input.nextLine();
                System.out.println("Введите автора: ");
                String author = input.nextLine();
                System.out.println("Введите дату издания книги: ");
                String data = input.nextLine();
                new OutLibrary(new Book(name1, author, data));
                System.out.println("Редактирование завершено успешно");
            }

            if (in == 2) {
                new InputLibrary().InputLibrary();
            }
        } while (in!=0);

    }
}
