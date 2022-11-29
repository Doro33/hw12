package Q1;

public class NumbersPrinter {
    private int count = 0;
    private final int MAX ;

    public NumbersPrinter(int MAX) {
        this.MAX = MAX;
    }
    public void printEven() {
        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking even loop.");
                while (count%2!=0) {
                    try {
                        System.out.println("Even waiting.");
                        wait();
                        System.out.println("Notified even.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even thread prints: " + count++);
                notify();
            }
        }
    }
    public void printOdd() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking odd loop.");
                while (count%2==0) {
                    try {
                        System.out.println("Odd waiting.");
                        wait();
                        System.out.println("Notified odd.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd thread Prints: " + count++);
                notify();
            }
        }
    }
}