package org.com.storage.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**

Author: Gariman
Date: 30/07
About (the class ): Employee class stores Employee info like first name, last name etc
Description (of respective properties): has contructors and get fucntion
        */
public class Employee implements Comparable<Employee>{
    private int empno;
    private String firstName;
    private String lastName;
    private String city;
    private long salary;

    //adding Local date in employee Q3(a)
    private LocalDate date;


    //making the contructor for the given class
    public Employee(int empno, String firstName, String lastName, String city, long salary,
                    LocalDate date) {
        this.empno = empno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.salary = salary;
        this.date = date;
    }
    //returning employee id
    public int getEmpno() {
        return empno;
    }

    //using to print employee
    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    //Overriding hash code equals Compaer too using compareable interface Q3(b)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empno == employee.empno;
    }

    @Override
    public int compareTo(Employee o) {
        return  Integer.compare(this.empno, o.empno);
    }
    @Override
    public int hashCode() {
        return Objects.hash(empno);
    }
}
