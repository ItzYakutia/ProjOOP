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
        this.attestation1 = attestation1;
        this.attestation2 = attestation2;
        this.finalExam = finalExam;
        calculateTotal(); // Автоматический подсчёт итоговой оценки при создании
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
        this.attestation1 = attestation1;
        calculateTotal(); // Пересчёт итоговой оценки
    }

    public double getAttestation2() {
        return attestation2;
    }

    public void setAttestation2(double attestation2) {
        this.attestation2 = attestation2;
        calculateTotal(); // Пересчёт итоговой оценки
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
        calculateTotal(); // Пересчёт итоговой оценки
    }

    public double getTotal() {
        return total;
    }

    private void calculateTotal() {
        this.total = (attestation1 * 0.3) + (attestation2 * 0.3) + (finalExam * 0.4); // Весовая схема
    }

    @Override
    public String toString() {
        return "Mark{" +
                "student=" + student.getNameFirst() + " " + student.getNameLast() +
                ", course=" + course.getName() +
                ", attestation1=" + attestation1 +
                ", attestation2=" + attestation2 +
                ", finalExam=" + finalExam +
                ", total=" + total +
                '}';
    }

	public void setTotal(double total2) {
		this.total = total2;
	}
}
