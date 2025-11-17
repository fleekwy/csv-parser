package ru.vsu.models;

import java.util.Objects;

public class Division {
    private int id;
    private String name;

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name; // Для удобного вывода
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Division division = (Division) o;
        return Objects.equals(name, division.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}