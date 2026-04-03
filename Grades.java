import java.util.*;

public class Grades {
    public static void main(String[] args) {

        
        Map<String, Double> students = new HashMap<>();

        
        students.put("Omar",   3.92);
        students.put("Elnur",     3.98);
        students.put("Ibrahim", 3.73);
        students.put("Arzu",   3.6);
        students.put("Nicat",     3.7);
        students.put("Davud",   2.5);
        students.put("Asad",   3.2);

        
        double highestGpa = Collections.max(students.values());

        System.out.println("=== Highest GPA ===");
        System.out.println("Highest GPA: " + highestGpa);
        System.out.print("Student(s): ");
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            if (entry.getValue() == highestGpa) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();

        
        double sum = 0;
        for (double gpa : students.values()) {
            sum += gpa;
        }
        double averageGpa = sum / students.size();

        System.out.println("\n=== Average GPA ===");
        System.out.printf("Average GPA: %.2f%n", averageGpa);

        
        int countBelowAverage = 0;
        for (double gpa : students.values()) {
            if (gpa < averageGpa) {
                countBelowAverage++;
            }
        }

        System.out.println("\n=== Below Average ===");
        System.out.println("Students below average GPA: " + countBelowAverage);

        System.out.println("\n=== All Students (Sorted by GPA) ===");
        students.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%-10s -> %.1f%n", e.getKey(), e.getValue()));
    }
}