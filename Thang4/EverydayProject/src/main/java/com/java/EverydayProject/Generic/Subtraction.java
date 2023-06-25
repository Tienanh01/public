package com.java.EverydayProject.Generic;

import java.util.Scanner;

@FunctionalInterface
public interface Subtraction {

    void subtract();
}

class Main {

    public static void main(String[] args) {

        // take two int input from the user
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        // create an anonymous class that implements subtract() interface
        // subtract() method must print the result of num1 - num2
     Subtraction obj = () ->{
         System.out.println(num1-num2);
     };
     obj.subtract();
    }
}
