package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.models.Application;
import br.com.kesley.jobextra.models.pk.ApplicationPK;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationPK>{
    
}