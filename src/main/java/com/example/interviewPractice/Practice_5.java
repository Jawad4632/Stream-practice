package com.example.interviewPractice;


import java.util.*;
import java.util.stream.Collectors;

class Employees {
    String department;
    String name;
    int age;
    double salary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Employees(String department, String name, int age, double salary) {
        this.department = department;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class Practice_5 {
    public static void main(String[] args) {
        List<Employees> employees = Arrays.asList(
                new Employees("Engineering", "Alice", 30, 120000),
                new Employees("Engineering", "Bob", 40, 160000),
                new Employees("Sales", "Charlie", 25, 90000),
                new Employees("Sales", "Diana", 30, 95000),
                new Employees("HR", "Eve", 35, 70000),
                new Employees("HR", "Evel", 35, 2000)
        );

//   Given a list of Employee objects (each with department, name, age, and salary),
//   use the Java Stream API to produce a Map<String, Optional<Employee>> that maps
//   each department to the employee in that department who has the highest salary-to-age ratio.
        Map<String, Optional<Employees>> result = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.maxBy(Comparator.comparingDouble(e -> e.salary / e.age))));

        result.forEach((key, value) -> value.ifPresent(emp -> System.out.println(key + "->" + emp.getName())));

//   Use Java Streams to create a Map<String, Double> where each key is a department, and the value is the average salary of employees in that department.
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.averagingDouble(Employees::getSalary)));

        averageSalary.forEach((s, employee) -> System.out.println(s + "->" + employee));

//   Create a Map<String, Optional<Employee>> mapping each department to its youngest employee using Java Streams.
        Map<String, Optional<Employees>> youngestEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.minBy(Comparator.comparingInt(Employees::getAge))));

        youngestEmployee.forEach((key,value)->value.ifPresent(emp -> System.out.println(key + "->" + emp.getName())));

//   Produce a Map<String, List<String>> where each department maps to a list of employee names sorted alphabetically
        Map<String, List<String>> departmentToNames = employees.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDepartment,
                        Collectors.mapping(Employees::getName, Collectors.toList())
                ));

        departmentToNames.values().forEach(Collections::sort);
        departmentToNames.forEach((dept, names) ->
                System.out.println(dept + " -> " + names)
        );

//   Find the employee with the highest salary across all departments using Streams
        Map<String, Optional<Employees>> highSalary = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary))));
        highSalary.forEach((key,value)->value.ifPresent(emp -> System.out.println(key + "->" + emp.getName())));


//        Classify employees into three brackets:
//        "Low" (salary < 75,000),
//        "Medium" (75,000 ≤ salary < 120,000),
//        "High" (salary ≥ 120,000) Return a Map<String, List<String>> of bracket → employee names.//

        Map<String, List<Employees>> classification = employees.stream()
                .collect(Collectors.groupingBy(employees1 -> {
                    if (employees1.salary < 75000) return "low";
                    else if (employees1.salary < 120000) return "medium";
                    else return "high";
                }));

        classification.forEach((bracket, list) -> {
            System.out.println(bracket + " -> " + list.stream()
                    .map(Employees::getName)
                    .toList());
        });

//        Use Java Streams to create a Map<String, Long> where each key is a department, and the value is the number of employees in that department.

        Map<String, Long> employeeWithDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));

        System.out.println(employeeWithDepartment);

//     Find the department that has the highest combined salary among its employees. (Return just the department name.)
        employees.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.summingDouble(Employees::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(emp -> System.out.println(emp.getKey()));

//    For each department, list the employees whose salary is above the department’s average. Return a Map<String, List<Employee>>.

//    Flatten all employee names into a single List<String> and sort them alphabetically using Streams.

//    For each department, compute and return a custom summary: Map<String, String> Where each value is a formatted string like: "Count: X, Total Salary: Y, Average Salary: Z"

    }



}
