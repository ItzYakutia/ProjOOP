package Models;

import java.util.List;

import javax.naming.InsufficientResourcesException;

public class Rector extends Employee{
    private static Rector instance; // Singleton instance
    private String name;
    private double universityBudget;

    public Rector(String username, String password, String userId, String nameFirst, String nameLast, String email,
    		double budget) {
    		super(username, password, userId, nameFirst, nameLast, email);
    		this.universityBudget = budget;
    }

    public static Rector getInstance(double budget) {
        if (instance == null) {
            try {
				instance = new Rector(instance.getUsername(), instance.password, instance.getUserId(), instance.getNameFirst(), instance.getNameLast(), instance.getEmail(), budget);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public double getUniversityBudget() {
        return universityBudget;
    }

    public void manageBudget(double amount) throws InsufficientResourcesException {
        if (amount < 0 && Math.abs(amount) > universityBudget) {
            throw new InsufficientResourcesException("Not enough budget for this operation!");
        }
        universityBudget += amount;
    }
}
