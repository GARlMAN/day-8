package org.com.storage.execptions;

//custom EmployeeNotFoundException Exception class
public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}