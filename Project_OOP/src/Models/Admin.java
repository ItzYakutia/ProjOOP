package Models;

import utils.FileDatabaseHelper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Admin extends User{

    public Admin(String username, String password, String userId, String email, String nameLast, String nameFirst) {
		super(username, password, userId, email, nameLast, nameFirst);
	}

	public boolean saveStudent(Student student) {
        try {
            FileDatabaseHelper.saveRecord("STUDENT:" + student.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving student to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean saveTeacher(Teacher teacher) {
        try {
            FileDatabaseHelper.saveRecord("TEACHER:" + teacher.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving teacher to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean saveAdmin(Admin admin) {
        try {
            FileDatabaseHelper.saveRecord("ADMIN:" + admin.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving admin to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean saveManager(Manager manager) {
        try {
            FileDatabaseHelper.saveRecord("MANAGER:" + manager.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving manager to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean saveRector(Rector rector) {
        try {
            FileDatabaseHelper.saveRecord("RECTOR:" + rector.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving rector to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean saveDean(Dean dean) {
        try {
            FileDatabaseHelper.saveRecord("DEAN:" + dean.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving dean to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean saveResearcher(Researcher researcher) {
        try {
            FileDatabaseHelper.saveRecord("RESEARCHER:" + researcher.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving researcher to the database: " + e.getMessage());
            return false;
        }
    }

    public List<User> getAllUsers() {
        try {
            return FileDatabaseHelper.getAllRecords().stream()
                    .map(this::parseUserRecord)
                    .toList();
        } catch (IOException e) {
            System.out.println("Error fetching users from the database: " + e.getMessage());
            return null;
        }
    }

    public User getUserDetails(String userId) {
        try {
            String record = FileDatabaseHelper.findRecord(userId);
            if (record != null) {
                return parseUserRecord(record);
            }
        } catch (IOException e) {
            System.out.println("Error fetching user details from the database: " + e.getMessage());
        }
        return null;
    }

    public boolean updateUser(User user, String newEmail, String newPassword) {
        try {
            String record = FileDatabaseHelper.findRecord(user.getUserId());
            if (record != null) {
                String updatedRecord = record.replace(user.toString(), user.setDetails(newEmail, newPassword));
                
                FileDatabaseHelper.saveAllRecords(FileDatabaseHelper.getAllRecords());
                return true;
            }
        } catch (IOException e) {
            System.out.println("Error updating user in the database: " + e.getMessage());
        }
        return false;
    }



    public boolean deleteUser(String userId) {
        try {
            FileDatabaseHelper.deleteRecord(userId);
            return true;
        } catch (IOException e) {
            System.out.println("Error deleting user from the database: " + e.getMessage());
            return false;
        }
    }

    // Helper method to parse user records from the database
    private User parseUserRecord(String record) {
        String[] parts = record.split(":");
        String type = parts[0];
        String userId = parts[1];
        String firstName = parts[2];
        String lastName = parts[3];
        String email = parts[4];

        switch (type) {
            case "STUDENT":
                return new Student(email, email, email, email, email, email, 0, 0, 0, null, null, null);
            case "TEACHER":
                return new Teacher(userId, firstName, lastName, email, email, email, Title.valueOf(parts[6]));
            case "ADMIN":
                return new Admin(email, email, email, email, email, email);
            case "MANAGER":
                return new Manager(userId, firstName, lastName, email, parts[6], email, email, Integer.parseInt(parts[7]));
            case "RECTOR":
                return Rector.getInstance(userId, firstName, lastName, email, email, Double.parseDouble(parts[6]), parts[7]);
            case "DEAN":
                return new Dean(userId, firstName, lastName, email, email, School.valueOf(parts[6]), parts[7]);
            case "RESEARCHER":
                return new Researcher(userId, firstName, lastName, email, parts[6], email);
            case "FINANCEMANAGER":
            	return new FinanceManager(email, email, email, email, email, email, email, 0, email, 0);
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Admin " + getNameFirst() + " received notification: " + message);
    }
    
    @Override
    public void sendMessage(String recipientUserId, String message) {
        System.out.println("Message from " + getUserId() + " to " + recipientUserId + ": " + message);
    }
    
    public boolean saveNews(News news) {
        try {
            FileDatabaseHelper.saveRecord("NEWS:" + news.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Error saving news to the database: " + e.getMessage());
            return false;
        }
    }

    public List<News> getAllNews() {
        try {
            return FileDatabaseHelper.getAllRecords().stream()
                    .filter(record -> record.startsWith("NEWS:"))
                    .map(this::parseNewsRecord)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error fetching news from the database: " + e.getMessage());
            return null;
        }
    }

    public News getNewsByTitle(String title) {
        List<News> newsList = getAllNews();
		if (newsList != null) {
		    return newsList.stream()
		            .filter(news -> news.getTitle().equals(title))
		            .findFirst()
		            .orElse(null);
		}
        return null;
    }

    public boolean updateNews(String title, String newContent) {
        try {
            List<News> newsList = getAllNews();
            if (newsList != null) {
                for (int i = 0; i < newsList.size(); i++) {
                    News news = newsList.get(i);
                    if (news.getTitle().equals(title)) {
                        newsList.set(i, new News(news.getTitle(), newContent, news.getAuthor(), news.getType(), news.getTimestamp()));
                        FileDatabaseHelper.saveAllRecords(newsList.stream().map(News::toString).collect(Collectors.toList()));
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating news: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteNews(String title) {
        try {
            List<News> newsList = getAllNews();
            if (newsList != null) {
                boolean removed = newsList.removeIf(news -> news.getTitle().equals(title));
                if (removed) {
                    FileDatabaseHelper.saveAllRecords(newsList.stream().map(News::toString).collect(Collectors.toList()));
                }
                return removed;
            }
        } catch (IOException e) {
            System.out.println("Error deleting news: " + e.getMessage());
        }
        return false;
    }

    private News parseNewsRecord(String record) {
        String[] parts = record.split(":");
        String title = parts[1];
        String content = parts[2];
        String author = parts[3];
        NewsType type = NewsType.valueOf(parts[4]);
        String timestamp = parts[5];
        return new News(title, content, author, type, timestamp);
    }
}
