import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        Map<Student, Integer> studentCount = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String nume = parts[0] + " " + parts[1];
                String grupa = parts[2];
                List<Integer> note = Arrays.stream(Arrays.copyOfRange(parts, 3, parts.length))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                Student student = new Student(nume, grupa, note);
                studenti.add(student);
                studentCount.put(student, studentCount.getOrDefault(student, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
        }
        
        System.out.println("Număr de apariții pentru fiecare student:");
        studentCount.forEach((student, count) -> System.out.println(student + " - Apare de " + count + " ori"));
    }
}

