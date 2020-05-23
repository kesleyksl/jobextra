package br.com.kesley.jobextra.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Company extends User {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<Job> jobs = new HashSet<>(); 
    
    public Company() {
        super(UserCategoryEnum.CORPORATE);

    }
    
}