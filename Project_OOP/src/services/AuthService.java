package services;

import java.io.IOException;






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
                    case "DEAN" -> new Dean(userId, firstName, lastName, email, additionalInfo);
                    case "RECTOR" -> new Rector(userId, firstName, lastName, email, Double.parseDouble(additionalInfo));
                    default -> null;
                };
            }
        }
        return null; // Логин неуспешен
    }
}
