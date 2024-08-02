package org.com.storage;

// Extending Thread class
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Extending Thread class: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Implementing Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Implementing Runnable interface: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Synchronized method example
class SynchronizedExample {
    public synchronized void printCount() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Synchronized method: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SyncThread extends Thread {
    SynchronizedExample syncExample;

    SyncThread(SynchronizedExample syncExample) {
        this.syncExample = syncExample;
    }

    public void run() {
        syncExample.printCount();
    }
}

public class TestThreads {
    public static void main(String[] args) {
        // Test extending Thread class
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.run();
        t2.run();

        // Ensure t1 and t2 finish before proceeding
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test implementing Runnable interface
        Thread t3 = new Thread(new MyRunnable());
        Thread t4 = new Thread(new MyRunnable());

        t3.start();
        t4.start();

        // Ensure t3 and t4 finish before proceeding
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test synchronized method
        SynchronizedExample example = new SynchronizedExample();

        SyncThread t5 = new SyncThread(example);
        SyncThread t6 = new SyncThread(example);

        t5.start();
        t6.start();
    }
}
