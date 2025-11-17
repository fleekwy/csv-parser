package ru.vsu.models;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private String gender;
    private Division division;
    private int salary;
    private LocalDate birthDate;

    public Person(int id, String name, String gender, LocalDate birthDate, Division division, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Division getDivision() {
        return division;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", division=" + division.getName() +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}