package ru.vsu;

import com.opencsv.exceptions.CsvException;
import ru.vsu.models.Person;
import ru.vsu.services.CsvReaderService;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CsvReaderService readerService = new CsvReaderService();
        String filePath = "foreign_names.csv";

        try {
            List<Person> people = readerService.readPersons(filePath);
            System.out.println("Успешно прочитано " + people.size() + " записей.");

            for (int i = 0; i < 10 && i < people.size(); i++) {
                System.out.println(people.get(i));
            }
        } catch (IOException | CsvException e) {
            System.err.println("Ошибка при чтении или парсинге файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}