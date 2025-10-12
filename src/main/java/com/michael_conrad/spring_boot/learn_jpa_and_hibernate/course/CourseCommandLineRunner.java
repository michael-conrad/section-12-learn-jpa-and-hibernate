package com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course;

import com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.jdbc.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        int id = 0;
        repository.insert(new Course(++id, "Learn AWS Now!", "in28minutes"));
        repository.insert(new Course(++id, "Learn Azure Now!", "in28minutes"));
        repository.insert(new Course(++id, "Learn DevOps Now!", "in28minutes"));
        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
