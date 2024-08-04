package org.com.storage.storage;
import org.com.storage.entity.Employee;
import org.com.storage.execptions.EmployeeAlreadyExistsException;
import org.com.storage.execptions.EmployeeNotFoundException;

/**

 Author: Gariman
 Date: 30/07
 About (the class ): storage impli implemends storage iterface and has methods related to it
 Description (of respective properties): has the same methods as storage interface and
 some extra attrubutes
 */

public class StorageImpl implements Storage{

    private Employee[] employees;//size to store the given array
    private int position; //keeps track of array position

    //constructor for the storage impli
    public StorageImpl(int size) {
        employees = new Employee[size]; //dynamically making array of the given size
    }

    //gets employee from the given array
    @Override
    public Employee getEmployee (int empno) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getEmpno() == empno)
                return employee;
        }
        throw new EmployeeNotFoundException("Employee with ID " + empno + " not found."); //returning null if it doesn't exist
    }


    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        //checking if employee exists
        for (int i = 0; i < position; i++) {
            if (employees[i].getEmpno() == e.getEmpno()) {
                throw new EmployeeAlreadyExistsException("Employee with ID " + e.getEmpno() +
                        " already exist."); //throwing Exception
            }
        }
        //adding employees
        if(position < employees.length) {
            System.out.println("employee added");
            employees[position++] = e; //ADDING E TO EMPLOYEEES ARRAY
        }
        else
            throw new EmployeeAlreadyExistsException("employees array is full!!!!"); //throwing Exception if employye array is full
    }
    public int employeeLength (){
        return employees.length;
    }

}
