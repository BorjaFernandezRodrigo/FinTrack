package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
// Test
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserService service = new UserService();

    @Test
    void findsExistingUser() {
        Optional<String> name = service.findName(1);
        assertTrue(name.isPresent());
        assertEquals("Ana", name.get());
    }

    @Test
    void returnsEmptyForUnknownId() {
        assertTrue(service.findName(99).isEmpty());
    }

    @Test
    void getNameOrDefaultReturnsName() {
        assertEquals("Ana", service.getNameOrDefault(1));
    }

    @Test
    void getNameOrDefaultReturnsDefault() {
        assertEquals("Desconocido", service.getNameOrDefault(99));
    }
}
