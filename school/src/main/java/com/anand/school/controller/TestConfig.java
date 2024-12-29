package com.anand.school.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {

    @Value("${application.config.students-url}")
    private String studentsUrl;

    @PostConstruct
    public void test() {
        System.out.println("Students URL: " + studentsUrl);
    }
}
