package com.sbr.service;

import com.sbr.model.Student;

import java.util.List;


public interface IStudentService {

    Student addStudent(Student student);
    List<Student> getStudents();

    Student updateStudent(Student student,Integer id);

    Student getStudentById(Integer id);

    void deleteStudent(Integer id);


}
