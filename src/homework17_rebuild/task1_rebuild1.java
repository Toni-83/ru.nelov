package homework17_rebuild;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class Book implements Serializable {
    private static final long serialVersionUID = -3601013367680481060L;
    String name;
    String author;
    String data;

    public Book(String name, String author, String data) {
        this.name = name;
        this.author = author;
        this.data = data;
    }

    public void printBook() {
        System.out.printf("Название книги: %s\nгод выпуска: %s\tавтор: %s.\n", name, data, author);
    }
}

class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    LinkedList<Book> library = new LinkedList<>();

    public void addBook() throws IOException, ClassNotFoundException {
        library = File.readFilesLibrary().library;
        //if (library!=null) this.library = library;
        //Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("Добавление книги в список библиотеки.");
        System.out.println("Введите название книги: ");
        String name = input.nextLine();
        System.out.println("Введите автора: ");
        String author = input.nextLine();
        System.out.println("Введите дату издания книги: ");
        String data = input.nextLine();
        Book book = new Book(name, author, data);
        this.library.add(this.library.size(), book);
        File.writeFilesLibrary(Library.this);
    }

    public void printListBook() throws IOException, ClassNotFoundException {
        library = File.readFilesLibrary().library;
        if (library.isEmpty()){
            return;
        }

        int ii = 0;
        Scanner input = new Scanner(System.in);
        do {
            for (int i = 0; (i < 5 && i + ii < library.size()); i++) {
                System.out.print((i + 1 + ii) + ". ");
                library.get(i + ii).printBook();
            }
            System.out.println("Для продолжения введите любое число, или введите 0 для прекращения вывода списка.");
            String inp = input.nextLine();
            if (Integer.parseInt(inp) == 0) break;
            ii += 5;
        } while (ii < library.size());
    }

    public void deleteBookFromList() throws IOException, ClassNotFoundException {
        this.library = File.readFilesLibrary().library;
        System.out.print("Для удаления элемента введите 0, для завершения удаления элементов введите \"Exit\"." +
                "\n Для продолжения выбора введите любое число: ");
        int i = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print((i + 1) + ". ");
            library.get(i).printBook();
            String in = input.toString();
            if (in.equals("Exit")) break;
            if (Integer.parseInt(in) == 0) {
                System.out.println("Введите название книги: ");
                String name = input.nextLine();
                System.out.println("Введите автора: ");
                String author = input.nextLine();
                System.out.println("Введите дату издания книги: ");
                String data = input.nextLine();
                library.get(i).name = name;
                library.get(i).author = author;
                library.get(i).data = data;
            }
        } while (i < library.size());
        File.writeFilesLibrary(Library.this);
    }

    public void changeStringBook() throws IOException, ClassNotFoundException {
        this.library = File.readFilesLibrary().library;
        System.out.print("Для изменения элемента нажмите 0, для завершения изменения элементов введите \"Exit\"." +
                "\n Для продолжения выбора введите любое число: ");
        int i = 0;
        Scanner inout = new Scanner(System.in);
        do {
            System.out.print((i + 1) + ". ");
            library.get(i).printBook();
            String in = inout.toString();
            if (in.equals("Exit")) break;
            if (Integer.parseInt(in) == 0) break;
            {
                library.remove(library.get(i));
            }
        } while (i < library.size());
        File.writeFilesLibrary(Library.this);
    }
}

class File {
    public static Library readFilesLibrary() throws ClassNotFoundException, IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Library.txt"))) {
            Library library = (Library) in.readObject();
            return library;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.\n" +
                    "По завершении операции файл с данными будет создан автоматически.");
            return new Library();
        }
    }

    public static void writeFilesLibrary(Library output) throws IOException {
        try (ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("Library.txt"))) {
            ou.writeObject(output);
        }
    }
}
public class task1_rebuild1 {
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
                    library.printListBook();
                    break;
                case 2:
                    library.addBook();
                    System.out.println("Редактирование записей произведено успешно.");

                    break;
                case 3:
                    library.deleteBookFromList();
                    System.out.println("Удаление записей произведено успешно.");
                    break;
                case 4:
                    library.changeStringBook();
                    System.out.println("Редактирование записей произведено успешно.");

                default:
                    System.out.println("Значение введено не верно, попробуйте снова");
                    break;
            }
        }

    }
}
