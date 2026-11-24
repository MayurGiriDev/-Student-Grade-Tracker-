import java.util.ArrayList;
import java.util.Scanner;

/**
 * TASK 1 — Student Grade Tracker (CodeAlpha Java Internship)
 * Console-based app to input & manage student grades,
 * compute average / highest / lowest, and print a summary report.
 */
public class GradeTracker {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("     STUDENT GRADE TRACKER — CodeAlpha");
        System.out.println("==============================================");

        while (true) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addGrades();
                case 3 -> printSummaryReport();
                case 4 -> printClassStatistics();
                case 5 -> searchStudent();
                case 6 -> removeStudent();
                case 7 -> loadSampleData();
                case 8 -> {
                    System.out.println("Exiting... Goodbye! 👋");
                    return;
                }
                default -> System.out.println("⚠ Invalid choice! Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n---------------- MENU ----------------");
        System.out.println("1. Add Student");
        System.out.println("2. Add Grades to a Student");
        System.out.println("3. Display Summary Report");
        System.out.println("4. Display Class Statistics");
        System.out.println("5. Search Student by Name");
        System.out.println("6. Remove Student");
        System.out.println("7. Load Sample Data (Demo/Test)");
        System.out.println("8. Exit");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("⚠ Name cannot be empty!");
            return;
        }
        students.add(new Student(name));
        System.out.println("✔ Student \"" + name + "\" added successfully.");
    }

    private static void addGrades() {
        Student s = findStudent();
        if (s == null) return;

        int count = readInt("How many grades to enter for " + s.getName() + "? ");
        for (int i = 1; i <= count; i++) {
            double grade = readDouble("Enter grade " + i + " (0-100): ");
            s.addGrade(grade);
        }
        System.out.println("✔ Grades added for " + s.getName() + ".");
    }

    private static void printSummaryReport() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found. Add students first!");
            return;
        }
        System.out.println("\n================ SUMMARY REPORT ================");
        System.out.printf("%-20s %-10s %-10s %-10s %-8s %-8s%n",
                "Name", "Average", "Highest", "Lowest", "Grade", "Count");
        System.out.println("---------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-20s %-10.2f %-10.2f %-10.2f %-8s %-8d%n",
                    s.getName(), s.getAverage(), s.getHighest(),
                    s.getLowest(), s.getLetterGrade(), s.getGradeCount());
        }
        System.out.println("=================================================");
    }

    private static void printClassStatistics() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found. Add students first!");
            return;
        }
        double classSum = 0, classHigh = Double.MIN_VALUE, classLow = Double.MAX_VALUE;
        int totalGrades = 0;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            classSum += s.getAverage();
            if (s.getAverage() > classHigh) { classHigh = s.getAverage(); topStudent = s.getName(); }
            if (s.getAverage() < classLow)  { classLow  = s.getAverage(); lowStudent  = s.getName(); }
            totalGrades += s.getGradeCount();
        }

        System.out.println("\n============ CLASS STATISTICS ============");
        System.out.printf("Total Students        : %d%n", students.size());
        System.out.printf("Total Grades Recorded : %d%n", totalGrades);
        System.out.printf("Class Average         : %.2f%n", classSum / students.size());
        System.out.printf("Top Performer         : %s (%.2f)%n", topStudent, classHigh);
        System.out.printf("Lowest Performer      : %s (%.2f)%n", lowStudent, classLow);
        System.out.println("===========================================");
    }

    private static void searchStudent() {
        Student s = findStudent();
        if (s == null) return;
        System.out.println("\n--- Student Details ---");
        System.out.println("Name    : " + s.getName());
        System.out.println("Grades  : " + s.getGrades());
        System.out.printf("Average : %.2f%n", s.getAverage());
        System.out.printf("Highest : %.2f | Lowest: %.2f%n", s.getHighest(), s.getLowest());
        System.out.println("Letter  : " + s.getLetterGrade());
    }

    private static void removeStudent() {
        Student s = findStudent();
        if (s == null) return;
        students.remove(s);
        System.out.println("✔ Student \"" + s.getName() + "\" removed.");
    }

    /** Loads demo data so the app can be tested without manual input */
    private static void loadSampleData() {
        String[][] data = {
            {"Alice", "92", "85", "78"},
            {"Bob", "55", "63", "70"},
            {"Charlie", "88", "91", "95"}
        };
        for (String[] row : data) {
            Student s = new Student(row[0]);
            for (int i = 1; i < row.length; i++) s.addGrade(Double.parseDouble(row[i]));
            students.add(s);
        }
        System.out.println("✔ Sample data loaded (3 students).");
    }

    private static Student findStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        System.out.println("⚠ Student \"" + name + "\" not found!");
        return null;
    }

    // ---- Safe input helpers ----
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                if (val >= 0) return val;
            } catch (NumberFormatException ignored) {}
            System.out.println("⚠ Please enter a valid non-negative number.");
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException ignored) {}
            System.out.println("⚠ Please enter a valid number.");
        }
    }
}