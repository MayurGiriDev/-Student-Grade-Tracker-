import java.util.ArrayList;

/**
 * Represents a single student and their grades.
 */
public class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /** Adds a grade after validating it is in range 0–100 */
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("  ⚠ Invalid grade! Must be between 0 and 100.");
        }
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public int getGradeCount() {
        return grades.size();
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    public double getHighest() {
        if (grades.isEmpty()) return 0;
        double max = grades.get(0);
        for (double g : grades) if (g > max) max = g;
        return max;
    }

    public double getLowest() {
        if (grades.isEmpty()) return 0;
        double min = grades.get(0);
        for (double g : grades) if (g < min) min = g;
        return min;
    }

    /** Converts the average score into a letter grade */
    public String getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
}