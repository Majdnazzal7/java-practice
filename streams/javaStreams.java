package streams;

import java.util.*;
import java.util.stream.Collectors;

public class javaStreams {

    public static void main(String[] args) {

class Student {

    private String name;
    private int mark;
    private String department;

    public Student(String name, int mark, String department) {
        this.name = name;
        this.mark = mark;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " - " + mark + " - " + department;
    }
}








        // Original Data
        List<Student> students = List.of(
                new Student("Ali", 90, "CS"),
                new Student("Sara", 45, "IT"),
                new Student("Ahmad", 80, "CS"),
                new Student("Lina", 30, "IT"),
                new Student("Omar", 95, "CS"),
                new Student("Noor", 70, "IT")
        );

        // 1. FILTER: Get passed students
        List<Student> passedStudents = students.stream()
                .filter(student -> student.getMark() >= 50)
                .toList();

        System.out.println("Passed Students:");
        passedStudents.forEach(System.out::println);


        // 2. MAP: Get student names only
        List<String> studentNames = students.stream()
                .map(Student::getName)
                .toList();

        System.out.println("\nStudent Names:");
        System.out.println(studentNames);


        // 3. SORTED: Sort by mark descending
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(Student::getMark)
                        .reversed())
                .toList();

        System.out.println("\nSorted Students:");
        sortedStudents.forEach(System.out::println);


        // 4. REDUCE: Calculate total marks
        int totalMarks = students.stream()
                .map(Student::getMark)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Marks:");
        System.out.println(totalMarks);


        // 5. COLLECT: Collect names into one String
        String allNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));

        System.out.println("\nAll Names:");
        System.out.println(allNames);


        // 6. GROUPING BY: Group students by department
        Map<String, List<Student>> groupedStudents =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getDepartment
                        ));

        System.out.println("\nStudents By Department:");

        groupedStudents.forEach((department, studentList) -> {
            System.out.println(department + ":");

            studentList.forEach(System.out::println);
        });


        // 7. GROUPING BY: Group by pass/fail
        Map<String, List<Student>> result =
                students.stream()
                        .collect(Collectors.groupingBy(
                                student -> student.getMark() >= 50
                                        ? "Passed" : "Failed"
                        ));

        System.out.println("\nPassed / Failed:");

        result.forEach((status, studentList) -> {
            System.out.println(status + ": " + studentList);
        });

        List<String> resultt = students.stream()
        .filter(student -> student.getMark() >= 50)
        .map(student -> student.getName().toUpperCase())
        .sorted()
        .toList();

System.out.println(result);


//
List<Integer> marks = new ArrayList<>(
        List.of(90, 50, 80, 40, 100)
);

// Ascending
Collections.sort(marks);
System.out.println(marks);

// Descending
Collections.sort(marks, Comparator.reverseOrder());
System.out.println(marks);




    }
}
