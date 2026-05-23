package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
// Test
import org.junit.jupiter.api.Test;

class OptionalMapTest {

    UserService service = new UserService();

    @Test
    void upperCaseNameForExistingUser() {
        assertEquals(Optional.of("ANA"), service.getUpperCaseName(1));
    }

    @Test
    void upperCaseEmptyForMissingUser() {
        assertTrue(service.getUpperCaseName(99).isEmpty());
    }

    @Test
    void longNameReturnsPresent() {
        // "Ana" has length 3, minLength 2 → present
        assertTrue(service.getNameIfLong(1, 2).isPresent());
    }

    @Test
    void shortNameReturnsEmpty() {
        // "Ana" has length 3, minLength 5 → empty
        assertTrue(service.getNameIfLong(1, 5).isEmpty());
    }
}
