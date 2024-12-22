
package utils;

import java.io.*;
import java.util.*;


public class FileDatabaseHelper {

    private static final String DATABASE_FILE = "users.txt"; // Название файла базы данных

    // Сохранение записи в базу данных
    public static void saveRecord(String record) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE, true))) {
            writer.write(record);
            writer.newLine();
        }
    }

    // Поиск записи по userId
    public static String findRecord(String userId) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(userId + ":")) {
                    return line;
                }
            }
        }
        return null;
    }

    // Получение всех записей
    public static List<String> getAllRecords() throws IOException {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        }
        return records;
    }
}
