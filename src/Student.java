import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    String nume;
    String grupa;
    List<Integer> note;

    public Student(String nume, String grupa, List<Integer> note) {
        this.nume = nume;
        this.grupa = grupa;
        this.note = note;
    }

    public double getMedie() {
        return note.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public long getRestante() {
        return note.stream().filter(n -> n < 5).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) && Objects.equals(grupa, student.grupa) && Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, grupa, note);
    }

    @Override
    public String toString() {
        return nume + " (" + grupa + ") - Note: " + note + " - Medie: " + String.format("%.2f", getMedie()) + " - Restante: " + getRestante();
    }
}
