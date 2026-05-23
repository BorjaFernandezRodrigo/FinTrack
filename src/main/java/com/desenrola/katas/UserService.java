package com.desenrola.katas;

import java.util.Map;
import java.util.Optional;

public class UserService {

    private final Map<Integer, String> users = Map.of(1, "Ana");

    public Optional<String> findName(int id) {
        return Optional.ofNullable(users.get(id));
    }

    public String getNameOrDefault(int id) {
        return users.getOrDefault(id, "Desconocido");
    }

    public Optional<String> getUpperCaseName(int id) {
        return Optional.ofNullable(users.get(id)).map(String::toUpperCase);
    }

    public Optional<String> getNameIfLong(int id, int minLength) {
        return Optional.ofNullable(
            users.get(id).length() >= minLength ? users.get(id) : null
        );
    }
}
