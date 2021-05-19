package in.hp.spock.basics;

import java.util.List;
import java.util.stream.Collectors;

public class Collage {
    private List<Student> students;

    public Collage(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudentsFromGrade(String grade) {
        return students.stream().filter(student -> student.getGrade().equals(grade)).collect(Collectors.toList());
    }

    public List<Student> getStudentsAboveAge(int age) {
        return students.stream().filter(student -> student.getAge() > age).collect(Collectors.toList());
    }
}
