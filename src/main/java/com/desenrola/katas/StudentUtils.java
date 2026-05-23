package com.desenrola.katas;

import java.util.Comparator;
import java.util.List;

public class StudentUtils {

    public static List<Student> sortByGpaDesc(List<Student> students) {
        return students
            .stream()
            .sorted(Comparator.comparingDouble(Student::gpa).reversed())
            .toList();
    }

    public static List<Student> sortByName(List<Student> students) {
        return students
            .stream()
            .sorted(Comparator.comparing(Student::name))
            .toList();
    }
}
