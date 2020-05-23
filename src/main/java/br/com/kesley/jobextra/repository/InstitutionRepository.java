package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Integer>{
    
}