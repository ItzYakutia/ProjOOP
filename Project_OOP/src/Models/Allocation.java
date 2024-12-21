package Models;

import java.util.Date;

public class Allocation {
    private int departmentId;
    private double amount;

    public Allocation(int departmentId, double amount) {
        this.departmentId = departmentId;
        this.amount = amount;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "departmentId=" + departmentId +
                ", amount=" + amount +
                ", allocationDate=" + allocationDate +
                '}';
    }
}
