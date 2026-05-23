package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class StudentUtilsTest {

    List<Student> students = List.of(
        new Student("Carlos", 7.5),
        new Student("Ana", 9.2),
        new Student("Bob", 8.0)
    );

    @Test
    void sortByGpaDescending() {
        List<Student> sorted = StudentUtils.sortByGpaDesc(students);
        assertEquals("Ana", sorted.get(0).name());
        assertEquals("Carlos", sorted.get(2).name());
    }

    @Test
    void sortByNameAlphabetically() {
        List<Student> sorted = StudentUtils.sortByName(students);
        assertEquals("Ana", sorted.get(0).name());
        assertEquals("Bob", sorted.get(1).name());
    }
}
