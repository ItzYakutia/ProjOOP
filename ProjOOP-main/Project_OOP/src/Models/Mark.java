package Models;

public class Mark {
    private int attendance;
    private int midtermExam;
    private int finalExam;

    public Mark(int attendance, int midtermExam, int finalExam) {
        this.attendance = attendance;
        this.midtermExam = midtermExam;
        this.finalExam = finalExam;
    }

    public int getTotalMark() {
        return attendance + midtermExam + finalExam;
    }

    @Override
    public String toString() {
        return "Mark{" + "total=" + getTotalMark() + '}';
    }
}
