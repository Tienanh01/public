package com.java.EverydayProject.Generic;

import com.java.EverydayProject.PackageCurl.People;

public class MyClass<T> {


        public MyClass(T data){
            System.out.println(data);
        }

        public MyClass setMyClass(T data){
            return new MyClass(data);
        }

    public static void main(String[] args) {
        MyClass<String> myClass_string = new MyClass<>("anh");
        MyClass<People> myClass_people = new MyClass<>(new People());
            People p = new People(1l,"anh","Hải dương");
        myClass_people.setMyClass(p);
        System.out.println(p.getId()+"  "+p.getName()+" "+p.getAddress());
    }
}
