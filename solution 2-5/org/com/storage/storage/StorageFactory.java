package org.com.storage.storage;
import java.util.Scanner;
/**

 Author: Gariman
 Date: 30/07
 About (the class ): gives tbe instacne of the storage

 */
public class StorageFactory {
    public static Storage getStorage(int code) {

        //Q5 adding different codes in Storage Factory
        if(code == 1){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter size of employee array");
            return new StorageImpl(scanner.nextInt());
        }
        else if(code == 2)
            return new StorageListImpl();
        else if(code == 3)
            return new StorageSortedImpl();
        else
            return new StorageMapImpl();

    }
}