package org.com.storage.storage;

import org.com.storage.entity.Employee;
import org.com.storage.execptions.EmployeeAlreadyExistsException;
import org.com.storage.execptions.EmployeeNotFoundException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

/**

 Author: Gariman
 Date: 01/08
 About (the interface ): interface for storage implementations
 Description (of respective properties): has add employee and
 get employee which reads from txt file and adds to the employee array
 */
public class StorageFileImpl implements Storage{
    Employee[] employees;

    //class contructor used to find the number of lines
    public StorageFileImpl() {
        int size = 0;
        //counting the number of lines in employee.txt
        try (FileReader fileReader = new FileReader(new File("employee.txt"));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.readLine() != null) {
                size++; //adding no of lines
            }
            //printing array size
            System.out.println("size of employee array is " + size);
            employees = new Employee[size];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //adding elements from txt file to employees
    @Override
    public void addEmployee(Employee e) throws IOException {
        //try catch block
        try (FileReader fileReader = new FileReader(new File("employee.txt"));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line=null;
            String[] data=null;
            int pos=0;
            while ((line = bufferedReader.readLine()) != null) {
                data =line.split(",");
                //adding values
                employees[pos] = new Employee(Integer.parseInt(data[0]), data[1], data[2],
                        data[3], Integer.parseInt(data[0]), LocalDate.of(1990, 12, 12));
                pos++;
            }
            System.out.println("Employee details added");
        }
    }

    //printing empolyee with given employee number
    @Override
    public Employee getEmployee (int empno) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getEmpno() == empno)
                return employee;
        }
        //throwing error if employee with given id not found in the given array
        throw new EmployeeNotFoundException("Employee with ID " + empno + " not found."); //returning null if it doesn't exist
    }

    @Override
    public int employeeLength() {
        return 0;
    }

    public void displayEmployee(){
        System.out.println("Displaying all employees ");
        for(Employee e : employees){
            System.out.println(e);
        }
    }

}