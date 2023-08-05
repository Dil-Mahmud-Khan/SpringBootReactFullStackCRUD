package com.sbr.controller;

import lombok.RequiredArgsConstructor;
import com.sbr.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbr.respository.StudentRepository;
import com.sbr.service.IStudentService;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    private final IStudentService iStudentService;

    @GetMapping
   public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(
                iStudentService.getStudents(),HttpStatus.FOUND
        );
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){

        return iStudentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student UpdateStudent(@RequestBody Student student, @PathVariable Integer id){
        return iStudentService.updateStudent(student,id);
    }


    @DeleteMapping("/delete/{id}")
    public void DeleteStudent(@PathVariable Integer id){
         iStudentService.deleteStudent(id);
    }


    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id){

        return iStudentService.getStudentById(id);
    }


}
