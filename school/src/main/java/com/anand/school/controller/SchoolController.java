package com.anand.school.controller;

import com.anand.school.domain.School;
import com.anand.school.dto.FullSchoolResponse;
import com.anand.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        service.saveStudent(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool() {
        return ResponseEntity.ok(service.findAllStudents());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolWithStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
    }

}
