package org.com.storage.view;
import org.com.storage.entity.Employee;
import org.com.storage.execptions.EmployeeAlreadyExistsException;
import org.com.storage.execptions.EmployeeNotFoundException;
import org.com.storage.storage.Storage;
import org.com.storage.storage.StorageFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 Author: Gariman
 Date: 30/07
 About (the class ): UserUI all the data calling user interface things are done here
 Description (of respective properties): has two main functions acceptEmpDetailsAndStore &
                                         displayEmpByEmpno
 */

public class UserUI {

    private Storage storage;

    public UserUI() {
        this.storage = StorageFactory.getStorage();
    }

    //method adding employee to the employees array
    public void acceptEmpDetailsAndStore(){
        //Initializing scanner
        System.out.println("-----------------------------------------");
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i <= storage.employeeLength(); ++i){ //printing for loop for the size of the empid
            //getting details of the employee
            System.out.println("Enter employee " + i + " id");
            int empNO = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter employee " + i +" first Name");
            String firstName = scanner.nextLine();

            System.out.println("Enter employee " + i + " last Name");
            String lastName = scanner.nextLine();

            System.out.println("Enter employee " + i + " city");
            String city = scanner.nextLine();

            System.out.println("Enter employee " + i + " salary");
            long salary = scanner.nextLong();
            scanner.nextLine();
            //adding dates
            Employee employee = new Employee(empNO, firstName, lastName, city, salary,
                    LocalDate.of(1991, 12, 12)); //making employee object
            //adding employee to array 3 and checking for errors
            try {
                storage.addEmployee(employee);
                System.out.println("Employee added.");
            } catch (EmployeeAlreadyExistsException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void displayEmpByEmpno(){
        System.out.println("-------------------------");
        Scanner scanner = new Scanner(System.in);
        //finding employee in array and checking for execptions
        System.out.println("Enter employee ID of the employee you want to find -->");
        try {
            Employee emp = storage.getEmployee(scanner.nextInt());
            System.out.println(emp);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
