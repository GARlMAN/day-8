package org.com.storage.storage;

import org.com.storage.entity.Employee;
import org.com.storage.execptions.EmployeeAlreadyExistsException;
import org.com.storage.execptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Gariman
 * Date: 30/07
 * About (the class): StorageMapImpl implements Storage interface and uses HashMap to store Employee objects
 * Description (of respective properties): Implements the same methods as Storage interface with HashMap
 */
public class StorageMapImpl implements Storage {

    private Map<Integer, Employee> employeeMap;

    // Constructor for StorageMapImpl
    public StorageMapImpl() {
        employeeMap = new HashMap<>(); // Initializes the HashMap
    }

    // Gets employee by empno
    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(empno);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + empno + " not found.");
        }
        return employee;
    }

    @Override
    public int employeeLength() {
        return 0;
    }

    // Adds a new employee
    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        if (employeeMap.containsKey(e.getEmpno())) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + e.getEmpno() + " already exists.");
        }
        employeeMap.put(e.getEmpno(), e);
        System.out.println("Employee added: " + e);
    }

    // Gets the number of employees
    public int employeeCount() {
        return employeeMap.size();
    }
}
