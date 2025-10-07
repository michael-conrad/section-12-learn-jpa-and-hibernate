package com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_COURSE_SQL = """
            insert into course (id, name, author)
            values (1, 'Learn AWS', 'Teacher Man');
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_COURSE_SQL);
    }
}
