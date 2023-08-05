package com.sbr.respository;

import com.sbr.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student ,Integer> {

    Optional<Student> findByEmail(String email);
}
