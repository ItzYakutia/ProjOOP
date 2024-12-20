package Models;

public class FinanceOffice {
    private String officeName;

    public FinanceOffice(String officeName) {
        this.officeName = officeName;
    }

    @Override
    public String toString() {
        return "FinanceOffice{" + "officeName='" + officeName + '\'' + '}';
    }
}
