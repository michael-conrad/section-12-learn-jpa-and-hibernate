package com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.spirngdatajpa;

import com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
