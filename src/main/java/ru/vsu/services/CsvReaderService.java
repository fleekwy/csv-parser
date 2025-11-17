package ru.vsu.services;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ru.vsu.models.Division;
import ru.vsu.models.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервис для чтения и парсинга данных о людях из CSV-файла.
 */
public class CsvReaderService {

    private static final char SEPARATOR = ';';
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final Map<String, Division> divisionCache = new HashMap<>();
    private final AtomicInteger divisionIdGenerator = new AtomicInteger(1);

    /**
     * Читает данные из CSV-файла и преобразует их в список объектов Person.
     *
     * @param csvFilePath Путь к файлу в папке resources.
     * @return Список объектов Person.
     * @throws IOException  Если возникает ошибка чтения файла.
     * @throws CsvException Если возникает ошибка парсинга CSV.
     */
    public List<Person> readPersons(String csvFilePath) throws IOException, CsvException {
        List<Person> people = new ArrayList<>();

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(SEPARATOR)
                .build();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath)) {
            if (in == null) {
                throw new IOException("Файл не найден в ресурсах: " + csvFilePath);
            }

            try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in))
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build()) {

                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    Division division = divisionCache.computeIfAbsent(
                            nextLine[4],
                            name -> new Division(divisionIdGenerator.getAndIncrement(), name));

                    Person person = new Person(
                            Integer.parseInt(nextLine[0]),
                            nextLine[1],
                            nextLine[2],
                            LocalDate.parse(nextLine[3], DATE_FORMATTER),
                            division,
                            Integer.parseInt(nextLine[5]));
                    people.add(person);
                }
            }
        }
        return people;
    }
}