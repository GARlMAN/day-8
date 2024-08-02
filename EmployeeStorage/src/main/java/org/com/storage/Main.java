package org.com.storage;
import org.com.storage.view.UserUI;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserUI u = new UserUI();
        u.acceptEmpDetailsAndStore(); //callling UI function
        u.displayEmpByEmpno(); //finding employee by ID
    }
}