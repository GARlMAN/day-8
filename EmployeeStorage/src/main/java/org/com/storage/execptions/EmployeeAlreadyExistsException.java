package org.com.storage.execptions;

//custom EmployeeAlreadyExistsException Exception class
public class EmployeeAlreadyExistsException extends Exception {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
