package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
    
}