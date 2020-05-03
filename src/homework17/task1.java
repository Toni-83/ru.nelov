package homework17;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class Book implements Serializable{
    String name;
    String author;
    String data;
    public void book (String name, String author, String data){
        this.name=name;
        this.author=author;
        this.data=data;
    }
    public void printBook () {
        System.out.printf("Название книги: %s\nгод выпуска: %s\tавтор: %s.",name,data,author);
    }
}
class Library implements Serializable{
    private static final long serialVersionUID = 1L;
    LinkedList<Book> library = new LinkedList<>();
    public boolean addBook (LinkedList library) throws IOException{
        if (library!=null) this.library = library;
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("Добавление книги в список библиотеки.");
        System.out.println("Введите название книги: ");
        String name = input.nextLine();
        System.out.println("Введите автора: ");
        String author = input.nextLine();
        System.out.println("Введите дату издания книги: ");
        String data = input.nextLine();
        book.book(name,author,data);
        this.library.add(this.library.size(),book);
        return File.writeFilesLibrary(Library.this);
    }
    public void printListBook () throws IOException, ClassNotFoundException{
        library = File.readFilesLibrary().library;
        int ii = 0;
        Scanner input = new Scanner(System.in);
        do {
            for (int i=0;i<5;i++){
                library.get(i+ii).printBook();
            }
            if (input.nextLine()==null) break;
            ii+=5;
        }while (ii<library.size());
    }
    public boolean deleteBookFromList (Library libraryFile) throws IOException{
        this.library = libraryFile.library;
        System.out.print("Для удаления элемента нажмите Enter, для завершения удаления элементов введите \"Exit\"." +
                "\n Для продолжения выбора введите любое значение: ");
        int i = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print((i+1)+". ");
            library.get(i).printBook();
            String in = input.toString();
            if (in.equals("Exit")) break;
            if (in==null){
                System.out.println("Введите название книги: ");
                String name = input.nextLine();
                System.out.println("Введите автора: ");
                String author = input.nextLine();
                System.out.println("Введите дату издания книги: ");
                String data = input.nextLine();
                library.get(i).name=name;
                library.get(i).author=author;
                library.get(i).data=data;
            }
        }while (i<library.size());
        return File.writeFilesLibrary(Library.this);
    }
    public boolean changeStringBook(Library libraryFile) throws IOException{
        this.library = libraryFile.library;
        System.out.print("Для изменения элемента нажмите Enter, для завершения изменения элементов введите \"Exit\"." +
                "\n Для продолжения выбора введите любое значение: ");
        int i = 0;
        Scanner inout = new Scanner(System.in);
        do {
            System.out.print((i+1)+". ");
            library.get(i).printBook();
            String in = inout.toString();
            if (in.equals("Exit")) break;
            if (in==null){
                library.remove(library.get(i));
            }
        }while (i<library.size());
        return File.writeFilesLibrary(Library.this);
    }
}
class File {
    public static Library readFilesLibrary () throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Library.txt"));
        Library library = (Library) in.readObject();
        in.close();
        return library;
    }
    public static boolean writeFilesLibrary (Library output) throws IOException{
        ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("Library.txt"));
        ou.writeObject(output);
        ou.close();
        return true;
    }
}

public class task1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner instr = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            System.out.println("Домашняя библиотека.\n" +
                    "Введите 1 для вывода библиотеки.\n" +
                    "Введите 2 для внесения данных в библиотеку.\n" +
                    "Введите 3 для удаления записи из библиотеки.\n" +
                    "Введите 4 для редактирования записи в библиотеке.\n" +
                    "Введите \"Exit\" для завершения программы.");
            String inputs = instr.nextLine();
            if (inputs.equalsIgnoreCase("exit")) break;
                int input = Integer.parseInt(inputs);
            switch (input) {
                case 1:
                    try {
                       library.printListBook();
                    } catch (IOException e){
                        System.out.println("Файл не найден.\n" +
                                "Выберите пункт 2 и внесите данные в библиотеку, по завершении файл с данными будет создан автоматически.");
                    }
                    break;
                case 2 :
                    try {
                        if (library.addBook(File.readFilesLibrary().library))
                            System.out.println("Редактирование записей произведено успешно.");
                    }catch (IOException e) {
                        System.out.println("Файл не найден.\n" +
                                "По завершениии операции создания библиотеки файл будет создан автоматически.");
                        if(library.addBook(null))
                            System.out.println("Создание библиотеки произведено успешно.");
                    }
                    break;
                case 3 :
                    try {
                        if(library.deleteBookFromList(File.readFilesLibrary()))
                            System.out.println("Удаление записей произведено успешно.");
                    }catch (IOException e){
                        System.out.println("Файл не найден.\n" +
                                "Выберите пункт 2 и внесите данные в библиотеку, по завершении файл с данными будет создан автоматически.");
                    }
                    break;
                case 4 :
                    try {
                        if (library.changeStringBook(File.readFilesLibrary()))
                            System.out.println("Редактирование записей произведено успешно.");
                    } catch (IOException e) {
                        System.out.println("Файл не найден.\n" +
                                "Выберите пункт 2 и внесите данные в библиотеку, по завершении файл с данными будет создан автоматически.");
                    }
                default:
                    System.out.println("Значение введено не верно, попробуйте снова");
                    break;
            }
        }

    }
}
