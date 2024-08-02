package org.com.storage.storage;

import org.com.storage.entity.Employee;
import org.com.storage.execptions.EmployeeAlreadyExistsException;
import org.com.storage.execptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Author: Gariman
 * Date: 30/07
 * About (the class): StorageListImpl implements Storage interface and has methods related to it
 * Description (of respective properties): has the same methods as Storage interface and some extra attributes
 */
public class StorageSortedImpl implements Storage {

    private TreeSet<Employee> employees;

    // Constructor for StorageListImpl
    public StorageSortedImpl() {
        employees = new TreeSet<>(); // Initializes the ArrayList
    }

    // Gets employee by empno
    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getEmpno() == empno) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + empno + " not found.");
    }

    @Override
    public int employeeLength() {
        return 0;
    }

    // Adds a new employee
    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        for (Employee employee : employees) {
            if (employee.getEmpno() == e.getEmpno()) {
                throw new EmployeeAlreadyExistsException("Employee with ID " + e.getEmpno() + " already exists.");
            }
        }
        employees.add(e);
        System.out.println("Employee added: " + e);
    }

    // Gets the number of employees
    public int employeeCount() {
        return employees.size();
    }
}
