package com.java.EverydayProject.PackageCurl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@CrossOrigin("http://localhost:5500/")
public class PeopleController
{

    @Autowired
    public PeopleService peopleServiceRepo;

    @GetMapping("/get-all")
    public List<People> getall(){
        String str = "stackjava.com.ifdf";
        byte[] bytes = str.getBytes(); // Chuyển đổi chuỗi sang mảng byte

        int length = bytes.length; // Độ dài của chuỗi trong byte

        System.out.println("Length of the string in bytes: " + length);
        return  peopleServiceRepo.getAll();
    }

    @PostMapping("/add-people")
    public String InsertPeople(@RequestBody People people){

        if(peopleServiceRepo.insert(people)){
            return "update success";
        }
        return "update false";


    }

    public static void main(String[] args) {

    }
}
