package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        String input;
        while (true){
            System.out.print("Please enter a positive integer: ");
            input=scanner.nextLine();
            try {
                inputNumber=Integer.parseInt(input);
                if (inputNumber>0)
                     break;
                else
                    System.out.println("your input is not valid");
            }catch (Exception e){
                System.out.println("your input is not valid");
            }
        }
        NumbersPrinter numbersPrinter = new NumbersPrinter(inputNumber);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                numbersPrinter.printEven();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                numbersPrinter.printOdd();
            }
        });

        t1.start();
        t2.start();
    }
}