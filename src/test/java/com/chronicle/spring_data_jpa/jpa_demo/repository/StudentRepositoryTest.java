package com.chronicle.spring_data_jpa.jpa_demo.repository;

import com.chronicle.spring_data_jpa.jpa_demo.entity.Guardian;
import com.chronicle.spring_data_jpa.jpa_demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
// It is a "Slice Test" that only loads JPA components and uses an
// in-memory DB (H2) by default. I am using @SpringBootTest instead to load
// the full application context and test against the real configured database (MySQL).
//
// Note: @DataJpaTest is transactional and rolls back by default.
// Using @SpringBootTest here means test data is persisted to the database
// unless @Transactional is explicitly added.
//
// Use @DataJpaTest for scoped repository testing with auto-rollback.
// Currently, using @SpringBootTest for full integration testing.
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("lily123@gmail.com")
                .firstName("Lily")
                .lastName("Doe")
//                .guardianName("John")
//                .guardianEmail("johndoe@gmail.com")
//                .guardianMobile("99999999999")
                .build();

        studentRepository.save(student);
        
//        Student student2 = Student.builder()
//                .emailId("doly123@gmail.com")
//                .firstName("doly")
//                .lastName("Doe")
//                .guardianName("John")
//                .guardianEmail("johndoe@gmail.com")
//                .guardianMobile("99999999999")
//                .build();
//
//        studentRepository.save(student2);
    }
    
    @Test
    public void saveStudentWithGuardian() {
        
        Guardian guardian = Guardian.builder()
                .name("John")
                .email("johndoe@gmail.com")
                .mobile("99999999999")
                .build();
        
        Student student = Student.builder()
                .firstName("Pinky")
                .emailId("pinky@gmail.com")
                .lastName("Doe")
                .guardian(guardian)
                .build();
        
        studentRepository.save(student);
    }
    
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        
        System.out.println("studentList = " + studentList);
    }

}