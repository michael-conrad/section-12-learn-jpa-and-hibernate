package com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.jdbc;

import com.michael_conrad.spring_boot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    private static final String INSERT_COURSE_SQL = """
            insert into course (id, name, author)
            values (?, ?, ?);
            """;
    private static final String DELETE_QUERY = """
            delete from course where id=?
            """;

    private static final String SELECT_QUERY = """
            select * from course where id=?
            """;
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_COURSE_SQL, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, //
                new BeanPropertyRowMapper<>(Course.class), //
                id);
    }
}
