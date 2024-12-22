
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
    
    public static void updateDetails(String userId, String newDetails) throws IOException {
        List<String> records = getAllRecords();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (String record : records) {
                if (record.startsWith(userId + ":")) {
                    // Replace old details with new details
                    writer.write(newDetails);
                } else {
                    writer.write(record);
                }
                writer.newLine();
            }
        }
    }
    
    public static void deleteRecord(String userId) throws IOException {
        List<String> records = getAllRecords();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (String record : records) {
                if (!record.startsWith(userId + ":")) {
                    writer.write(record);
                    writer.newLine();
                }
            }
        }
    }

    public static void saveAllRecords(List<String> records) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        }
    }
}
