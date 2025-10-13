package com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course;

import com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.spirngdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //    @Autowired
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        int id = 0;

        repository.save(new Course(++id, "Learn AWS Now!", "in28minutes"));
        repository.save(new Course(++id, "Learn Azure Now!", "in28minutes"));
        repository.save(new Course(++id, "Learn DevOps Now!", "in28minutes"));
        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
    }
}
