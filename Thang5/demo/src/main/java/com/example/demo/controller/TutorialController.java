package com.example.demo.controller;


import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<>();

            if (title == null) {
                System.out.println("có chạy vô đây");
                tutorialRepository.findAll().forEach(tutorials::add);
            }
            else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
//
//    }
//
@PostMapping("/tutorials")
public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
    try {
        Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//
//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
//
//    }
//
//    @DeleteMapping("/tutorials/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
//
//    }
//
//    @DeleteMapping("/tutorials")
//    public ResponseEntity<HttpStatus> deleteAllTutorials() {
//
//    }
//
//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<Tutorial>> findByPublished() {
//
//    }

}