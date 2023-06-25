package com.java.EverydayProject.PackageCurl;

import java.util.LinkedList;
import java.util.Scanner;

class Main {

    public static void dequeue(){
        LinkedList<Integer> numberList = new LinkedList();

        // add elements to numberList
        numberList.add(5);
        numberList.add(10);
        numberList.add(15);
        // remove element from the front
        numberList.poll();

        // take an integer input from the user
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        // add the user input to the end of numberList
        numberList.offer(number);
        System.out.print(numberList);

        // print numbersList


        input.close();
    }
    public static void queue(){
        LinkedList<String> patient  = new LinkedList<>();
        patient.add("1st Patient");
        patient.add("2nd Patient");
        patient.add("3rd Patient");

        patient.poll();
        System.out.println(patient);
        patient.offer("4rd Patient");

        System.out.println(patient);
        patient.add("5rd Patient");
        System.out.println(patient);
    }
    public static void main(String[] args) {
dequeue();
        queue();
//
//        LinkedList<String> languages = new LinkedList();
//
//        // add elements to languages
//        languages.add("Java");
//        languages.add("Python");
//        // take input from user
//        Scanner input = new Scanner(System.in);
//        String language1 = input.nextLine();
//        languages.add(1,language1);
//        // insert the user input to language LinkedList
//
//        // print languages
//        System.out.println(languages);
//
//        input.close();
    }
}
