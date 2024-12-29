package com.anand.school.service;

import com.anand.school.client.StudentClient;
import com.anand.school.domain.School;
import com.anand.school.dto.FullSchoolResponse;
import com.anand.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class SchoolService {

    private  SchoolRepository repository;

    private StudentClient studentClient;

    public SchoolService(SchoolRepository repository, StudentClient studentClient) {
        this.repository = repository;
        this.studentClient = studentClient;
    }

    public void saveStudent(School school) {
        repository.save(school);
    }

    public List<School> findAllStudents(){
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        // this build is just to avoid nullPointer exception or unhandle exception.
        School obj = new School();
        obj.setName("Not Found");
        var school = repository.findById(schoolId).orElse(obj);
        var students = studentClient.findAllStudentBySchool(schoolId); // find student from student microservice.
        School sc = new School();
        FullSchoolResponse fsr = new FullSchoolResponse();
        fsr.setName(school.getName());
        fsr.setEmail(school.getEmail());
        fsr.setStudentList(students);
        return fsr;
        // return FullSchoolResponse.builder().name(school.getName()).email(school.getEmail()).studentList(students).build();
    }
}
