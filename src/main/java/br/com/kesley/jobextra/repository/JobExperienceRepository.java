package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.JobExperience;

public interface JobExperienceRepository extends JpaRepository<JobExperience, Integer>{
    
}