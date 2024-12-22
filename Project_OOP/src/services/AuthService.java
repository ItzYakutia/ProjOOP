package services;

import java.io.IOException;

import Models.*;
import utils.FileDatabaseHelper;

public class AuthService {

    // Метод авторизации пользователя
    public static Object login(String userId, String password) throws IOException {
        String record = FileDatabaseHelper.findRecord(userId);
        if (record != null) {
            String[] parts = record.split(":");
            String storedPassword = parts[5];
            if (storedPassword.equals(password)) {
                // Создаем объект соответствующего класса
                String type = parts[0];
                String firstName = parts[2];
                String lastName = parts[3];
                String email = parts[4];
                String additionalInfo = parts[6];

                return switch (type) {
                    case "DEAN" -> new Dean(userId, firstName, lastName, email, additionalInfo, null, additionalInfo);
                    case "RECTOR" -> Rector.getInstance(userId, firstName, lastName, email, additionalInfo, 23.4, additionalInfo);
                    case "ADMIN" -> new Admin(additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo);
                    case "STUDENT" -> new Student(additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, 0, 0, 0, null, null, null);
                    case "TEACHER" -> new Teacher(additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, null);
                    case "RESEARCHER" -> new Researcher(additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo);
                    case "MANAGER" -> new Manager(additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, 0);
                    case "FINANCEMANAGER" -> new FinanceManager(additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, additionalInfo, aadditionalInfo, 0, additionalInfo, 0);
                    default -> null;
                };
            }
        }
        return null; // Логин неуспешен
    }
}
