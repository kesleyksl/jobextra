package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
    
}