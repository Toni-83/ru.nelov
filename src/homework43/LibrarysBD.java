package homework43;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Connectors {
    private final String URL_DB_ROOT = "jdbc:postgresql://192.168.1.241:5432/";
    private final String URL = "jdbc:postgresql://192.168.1.241:5432/library";
    private final String USER = "postgres";
    private final String PASSWORD = "Antuan_83";
    public void createBD () {
        try (Connection connection = DriverManager.getConnection(URL_DB_ROOT, USER, PASSWORD); Statement statement = connection.createStatement()) {
            String sql = "CREATE DATABASE library\n" +
                    "    WITH \n" +
                    "    OWNER = postgres\n" +
                    "    TEMPLATE = template0\n" +
                    "    ENCODING = 'UTF8'\n" +
                    "    CONNECTION LIMIT = -1;\n ";
            int result = statement.executeUpdate(sql);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement()) {
            String sql ="CREATE TABLE public.card_index\n" +
                    "( book_ID int NOT NULL, author char (60), year_of_publishing char (10),book_title char (150), quantity int);\n" +
                    "CREATE TABLE public.readers\n" +
                    "( reader_ID int NOT NULL, name char (15), surname char (20), patronymic char (20));\n" +
                    "CREATE TABLE public.give_out\n" +
                    "(num_ID int NOT NULL, book_ID int NOT NULL, reader_ID int NOT NULL);\n" +
                    "ALTER TABLE public.card_index ADD\n" +
                    "CONSTRAINT PK_book PRIMARY KEY (book_ID);\n" +
                    "ALTER TABLE public.readers ADD\n" +
                    "CONSTRAINT PK_readers PRIMARY KEY (reader_ID);\n" +
                    "ALTER TABLE public.give_out ADD\n" +
                    "CONSTRAINT PK_give_out PRIMARY KEY (num_ID);\n" +
                    "ALTER TABLE public.give_out ADD\n" +
                    "CONSTRAINT FK_give_out_book FOREIGN KEY (book_ID) REFERENCES public.card_index (book_ID);\n" +
                    "ALTER TABLE public.give_out ADD\n" +
                    "CONSTRAINT FK_give_out_reader FOREIGN KEY (reader_ID) REFERENCES public.readers (reader_ID);";
            int result = statement.executeUpdate(sql);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class LibrarysBD {

    public static void main(String[] args) {
        Connectors con = new Connectors();
        con.createBD();

    }
}
