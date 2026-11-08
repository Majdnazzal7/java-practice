
import java.util.*;
import java.util.function.*;

public class JavaAdvanced {



 static class Student {

    private String name;
    private int mark;
    private String department;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
        this.department = "CS";
    }

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


    
    // 1. Custom Functional Interface
    @FunctionalInterface
    interface StudentChecker {
        boolean check(Student student);
    }

    public static void main(String[] args) {

        
        // Original Students
        List<Student> students = List.of(
                new Student("Ali", 90, "CS"),
                new Student("Sara", 45, "IT"),
                new Student("Ahmad", 80, "CS"),
                new Student("Lina", 30, "IT"),
                new Student("Omar", 95, "CS")
        );


        // 2. LAMBDA + CUSTOM FUNCTIONAL INTERFACE
        StudentChecker passedChecker =
                student -> student.getMark() >= 50;


        // 3. FILTER using Method Reference
        List<Student> passedStudents = students.stream()
                .filter(passedChecker::check)
                .toList();

        System.out.println("Passed Students:");
        passedStudents.forEach(System.out::println);


        // 4. PREDICATE
        Predicate<Student> excellent =
                student -> student.getMark() >= 90;

        List<Student> excellentStudents = students.stream()
                .filter(excellent)
                .toList();

        System.out.println("\nExcellent Students:");
        excellentStudents.forEach(System.out::println);


        // 5. FUNCTION + METHOD REFERENCE
        Function<Student, String> getName =
                Student::getName;

        List<String> names = students.stream()
                .map(getName)
                .toList();

        System.out.println("\nStudent Names:");
        System.out.println(names);


        // 6. CONSUMER + METHOD REFERENCE
        Consumer<Student> printer =
                System.out::println;

        System.out.println("\nPrinting Students:");

        students.forEach(printer);


        // 7. SUPPLIER + LAMBDA
        Supplier<Student> studentSupplier =
                () -> new Student("Noor", 88);

        Student newStudent = studentSupplier.get();

        System.out.println("\nSupplier Student:");
        System.out.println(newStudent);


        // 8. CONSTRUCTOR REFERENCE
        BiFunction<String, Integer, Student> studentFactory =
                Student::new;

        Student createdStudent =
                studentFactory.apply("Maya", 85);

        System.out.println("\nCreated Student:");
        System.out.println(createdStudent);


        // 9. STATIC METHOD REFERENCE
        List<String> rawMarks =
                List.of("90", "80", "70");

        List<Integer> marks = rawMarks.stream()
                .map(Integer::parseInt)
                .toList();

        System.out.println("\nConverted Marks:");
        System.out.println(marks);


        // 10. INSTANCE METHOD REFERENCE
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("\nUppercase Names:");
        System.out.println(upperNames);


        // 11. SORTED + METHOD REFERENCE
        List<Student> sortedStudents = students.stream()
                .sorted(
                    Comparator.comparingInt(Student::getMark)
                            .reversed()
                )
                .toList();

        System.out.println("\nSorted Students:");

        sortedStudents.forEach(System.out::println);
    }
}
