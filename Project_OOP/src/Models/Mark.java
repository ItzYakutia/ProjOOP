package Models;

public class Mark {

    private Student student; // Студент, получивший оценку
    private Course course; // Курс, за который выставлена оценка
    private double attestation1; // Оценка за первую аттестацию
    private double attestation2; // Оценка за вторую аттестацию
    private double finalExam; // Оценка за финальный экзамен
    private double total; // Итоговая оценка

    public Mark(Student student, Course course, double attestation1, double attestation2, double finalExam) {
        this.student = student;
        this.course = course;
        setAttestation1(attestation1);
        setAttestation2(attestation2);
        setFinalExam(finalExam);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getAttestation1() {
        return attestation1;
    }

    public void setAttestation1(double attestation1) {
        validateMark(attestation1);
        this.attestation1 = attestation1;
        calculateTotal();
    }

    public double getAttestation2() {
        return attestation2;
    }

    public void setAttestation2(double attestation2) {
        validateMark(attestation2);
        this.attestation2 = attestation2;
        calculateTotal();
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        validateMark(finalExam);
        this.finalExam = finalExam;
        calculateTotal();
    }

    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
    	this.total = total;
    }

    private void calculateTotal() {
        this.total = attestation1 * 0.3 + attestation2 * 0.3 + finalExam * 0.4;
    }

    private void validateMark(double mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100.");
        }
    }

    public boolean isPassed() {
        return total >= 50;
    }
}
