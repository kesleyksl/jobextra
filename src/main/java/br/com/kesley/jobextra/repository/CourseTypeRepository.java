package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.CourseType;

public interface CourseTypeRepository extends JpaRepository<CourseType, Integer>{
    
}