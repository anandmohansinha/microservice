package com.anand.student.service;

import com.anand.student.domain.Student;
import com.anand.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents(){
        return repository.findAll();
    }


    public List<Student> findAllStudentsBySchoolId(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
