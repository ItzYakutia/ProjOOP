package Models;

import java.util.List;
import java.util.Map;

public class FinanceOffice {
    private String officeName;
    private FinanceManager manager;
    private List<String> employees;
    private Map<String, Double> employeeSalaries; 

    public FinanceOffice(String officeName, FinanceManager manager, List<String> employees, Map<String, Double> employeeSalaries) {
        this.officeName = officeName;
        this.manager = manager;
        this.employees = employees;
        this.employeeSalaries = employeeSalaries;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }


    public FinanceManager getManager() {
        return manager;
    }

    public void setManager(FinanceManager manager) {
        this.manager = manager;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    public Map<String, Double> getEmployeeSalaries() {
        return employeeSalaries;
    }

    public void setEmployeeSalaries(Map<String, Double> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

    @Override
    public String toString() {
        StringBuilder employeeSalariesString = new StringBuilder();
        for (Map.Entry<String, Double> entry : employeeSalaries.entrySet()) {
            employeeSalariesString.append("\nEmployee ID: ").append(entry.getKey())
                                  .append(", Salary: $").append(entry.getValue());
        }
        
        return "Finance Office: " + officeName +
               "\nManager: " + manager.getNameFirst() + " " + manager.getNameLast() +
               "\nEmployees: " + employees +
               "\nEmployee Salaries: " + employeeSalariesString;
    }
}
