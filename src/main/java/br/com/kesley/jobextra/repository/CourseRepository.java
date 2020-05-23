package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}