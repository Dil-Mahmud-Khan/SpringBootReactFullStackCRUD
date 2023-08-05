package com.sbr.service;

import com.sbr.exception.StudentNotFoundException;
import com.sbr.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbr.respository.StudentRepository;

import java.util.List;


@Service

public class StudentService implements  IStudentService{

    @Autowired
     private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
//        if (studentAlreadyExists(student.getEmail())){
//            throw  new StudentAlreadyExistsException(student.getEmail()+"Already exists");
//        }

        return studentRepository.save(student);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();

    }
    @Override
    public List<Student> getStudents() {

        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student,Integer id) {

        return studentRepository.findById(id).map(st->{
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return  studentRepository.save(st);
        }).orElseThrow(()->new StudentNotFoundException("Student doesn't exists"));
    }

    @Override
    public Student getStudentById(Integer id) {

        return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found in this id"));
    }

    @Override
    public void deleteStudent(Integer id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}
