package homework17;

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

    public void addBook() throws IOException {
        try {
            library = File.readFilesLibrary().library;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.\n" +
                    "По завершениии операции файл с данными будет создан автоматически.");
        } catch (ClassNotFoundException c) {
            System.out.println("Файл библиотеки поврежден или имеет не верный формат данных.\n" +
                    "По завершении операции данные в файле будут перезаписаны, для продолжения операции нажмите Enter или любое значение.");
            if ((new Scanner(System.in).nextLine()) != null) return;
        }
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
        if (File.writeFilesLibrary(Library.this)) {
            System.out.println("Данные сохранены успешно.");
        }
    }

    public void printListBook() throws IOException {
        try {
            library = File.readFilesLibrary().library;
        } catch (Exception e) {
            addBook();
            return;
        }
        int ii = 0;
        Scanner input = new Scanner(System.in);
        do {
            for (int i = 0; (i < 5 && (i + ii) < library.size()); i++) {
                System.out.print((i + 1 + ii) + ". ");
                library.get(i + ii).printBook();
                if (library.size() == (i + ii + 1)) {
                    System.out.println("================================================================\\n" +
                            "Конец списка книг.\\n");
                    return;
                }
            }

            System.out.println("Для продолжения введите любое число, или введите 0 для прекращения вывода списка.");
            String inp = input.nextLine();
            if (Integer.parseInt(inp) == 0) break;
            ii += 5;
        } while (ii < library.size());
    }

    public void deleteBookFromList() throws IOException {
        try {
            library = File.readFilesLibrary().library;
        } catch (Exception e) {
            addBook();
            return;
        }
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
        if (File.writeFilesLibrary(Library.this)) {
            System.out.println("Изменения сохранены успешно.");
        }
    }

    public void changeStringBook() throws IOException {
        try {
            library = File.readFilesLibrary().library;
        } catch (Exception e) {
            addBook();
            return;
        }
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
        if (File.writeFilesLibrary(Library.this)) {
            System.out.println("Изменения сохранены успешно.");
        }
    }
}

class File {
    public static Library readFilesLibrary() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Library.txt"))) {
            Library library = (Library) in.readObject();
            return library;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        }

    }

    public static boolean writeFilesLibrary(Library output) throws IOException {
        try (ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("Library.txt"))) {
            ou.writeObject(output);
            return true;
        }


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
                    library.printListBook();
                    break;
                case 2:
                    library.addBook();
                    break;
                case 3:
                    library.deleteBookFromList();
                    break;
                case 4:
                    library.changeStringBook();
                default:
                    System.out.println("Значение введено не верно, попробуйте снова");
                    break;
            }
        }

    }
}
