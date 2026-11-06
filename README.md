# -Student-Grade-Tracker-
A console-based Java application to input and manage student grades. It calculates each student's average, highest, and lowest scores, assigns letter grades, and displays a clean summary report of all students — plus class-level statistics like top performer and class average.

✨ Features
➕ Add / remove students
📝 Enter multiple grades per student (validated 0–100)
📊 Per-student average, highest & lowest scores
🅰️ Automatic letter grade (A–F) based on average
📋 Formatted summary report of all students
🏆 Class statistics: class average, top & lowest performer
🔍 Search student by name
🧪 One-click demo data loader for quick testing

🛠 Tech Stack
Component	Detail
Language	Java (JDK 17+)
Data Structure	ArrayList<Student> & ArrayList<Double>
Paradigm	Object-Oriented Programming
Interface	Console-based (menu-driven)

📋 Sample Output
================ SUMMARY REPORT ================
Name                 Average    Highest    Lowest     Grade    Count
---------------------------------------------------------------
Alice                85.00      92.00      78.00      B        3
Bob                  62.67      70.00      55.00      D        3
Charlie              91.33      95.00      88.00      A        3
=================================================

============ CLASS STATISTICS ============
Total Students        : 3
Total Grades Recorded : 9
Class Average         : 79.67
Top Performer         : Charlie (91.33)
Lowest Performer      : Bob (62.67)
===========================================
