package org.com.storage.storage;
import java.util.Scanner;
/**

 Author: Gariman
 Date: 30/07
 About (the class ): gives tbe instacne of the storage

 */
public class StorageFactory {
    public static Storage getStorage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of employee array");
        return new StorageImpl(scanner.nextInt());
    }
}