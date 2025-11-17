package ru.vsu;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vsu.models.Person;
import ru.vsu.services.CsvReaderService;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для CsvReaderService.
 */
public class CsvReaderServiceTest {

    private CsvReaderService readerService;

    @BeforeEach
    void setUp() {
        readerService = new CsvReaderService();
    }

    @Test
    void testReadPersonsSuccessfully() throws IOException, CsvException {
        String testFilePath = "test_foreign_names.csv"; // Файл в src/test/resources
        List<Person> people = readerService.readPersons(testFilePath);

        assertNotNull(people);
        assertEquals(4, people.size()); // Укажите, сколько строк данных в вашем тестовом файле

        Person firstPerson = people.get(0);
        assertEquals(28281, firstPerson.getId());
        assertEquals("Aahan", firstPerson.getName());
        assertEquals("Male", firstPerson.getGender());
        assertEquals("I", firstPerson.getDivision().getName());
        assertEquals(4800, firstPerson.getSalary());
        assertEquals("1970-05-15", firstPerson.getBirthDate().toString());
    }

    @Test
    void testFileNotFound() {
        // Проверяем, что при отсутствии файла выбрасывается исключение
        assertThrows(IOException.class, () -> {
            readerService.readPersons("non_existent_file.csv");
        });
    }
}