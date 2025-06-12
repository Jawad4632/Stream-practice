package com.example.interviewPractice;

import java.time.LocalDate;

class Employee {
    private String name;
    private int age;
    private LocalDate birthDate;
    private float salary;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }


    public Employee(String name, int age, LocalDate birthDate, float salary) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                '}';
    }

}