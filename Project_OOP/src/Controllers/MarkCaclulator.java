package Models;

public class MarkCalculator {

    private static MarkCalculator instance;

    private MarkCalculator() {
    }

    public static MarkCalculator getInstance() {
        if (instance == null) {
            instance = new MarkCalculator();
        }
        return instance;
    }

    public double calculateTotal(double attestation1, double attestation2, double finalExam) {
        return (attestation1 * 0.3) + (attestation2 * 0.3) + (finalExam * 0.4);
    }
}
