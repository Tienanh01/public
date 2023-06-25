package com.java.EverydayProject.PackageCurl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    public PeopleJpa peopleJpaRepo;


    public List<People> getAll(){
        return peopleJpaRepo.findAll();
    }

    public boolean insert(People people){

        if( peopleJpaRepo.save(people) !=  null){
            return true;
        }
        return false;
    }
}
