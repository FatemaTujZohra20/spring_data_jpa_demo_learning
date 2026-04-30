package com.chronicle.spring_data_jpa.jpa_demo.repository;

import com.chronicle.spring_data_jpa.jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByFirstName(String firstName);
    
    List<Student> findByFirstNameContaining(String name);
    
    List<Student> findByLastNameNotNull();
    
    List<Student> findByGuardianName(String guardianName);
    
    // JPQL
    @Query("select s from Student s where s.firstName = ?1 and s.lastName = ?2")
    Student findByFirstNameAndLastName(String firstName, String lastName);
    

    
}
