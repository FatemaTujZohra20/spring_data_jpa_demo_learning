package com.chronicle.spring_data_jpa.jpa_demo.repository;

import com.chronicle.spring_data_jpa.jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByFirstName(String firstName);
    
    List<Student> findByFirstNameContaining(String name);
    
}
