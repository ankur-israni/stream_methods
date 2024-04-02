package com.core.newfeatures.java8.streams;

public class Employee {

    private String name;
    private int age;
    private float salary;
    private Location location;
    private Designation designation;

    public Employee(String name, int age, float salary, Location location, Designation designation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public Location getLocation() {
        return location;
    }

    public Designation getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", location=" + location +
                ", designation=" + designation +
                '}';
    }
}
