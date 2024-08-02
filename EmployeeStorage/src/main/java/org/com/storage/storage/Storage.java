package org.com.storage.storage;
import org.com.storage.entity.Employee; //calling employee class
import org.com.storage.execptions.EmployeeAlreadyExistsException;
import org.com.storage.execptions.EmployeeNotFoundException;

import java.io.IOException;

/**

 Author: Gariman
 Date: 30/07
 About (the interface ): interface for storage implementations
 Description (of respective properties): has add employee and
                                         get employee and given legthn of employee array
 */

public interface Storage  {
    void addEmployee(Employee e) throws EmployeeAlreadyExistsException, IOException;
    Employee getEmployee(int empno) throws EmployeeNotFoundException;

    //an extra methods this given Length of employees array
    int employeeLength();
}

