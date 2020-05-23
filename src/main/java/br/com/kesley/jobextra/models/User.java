package br.com.kesley.jobextra.models;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

  
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter(value = AccessLevel.NONE)
    @Column(nullable =  false)
    @Enumerated(EnumType.STRING)
    private UserCategoryEnum category;
    @Column(nullable =  false)
    private String name;

    @Column(nullable =  false, unique = true)
    private String document;


    @Column(nullable =  false, unique = true)
    private String email;
    
    private String telephone;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private byte[] photo;
    @Transient
    private String path;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createDate = Instant.now();

    @OneToOne
    private Address address;


    


    public User(UserCategoryEnum category){
        this.category = category;
    }

}