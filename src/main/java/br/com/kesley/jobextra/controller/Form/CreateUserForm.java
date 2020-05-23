package br.com.kesley.jobextra.controller.Form;


import java.time.LocalDate;

import br.com.kesley.jobextra.models.UserCategoryEnum;
import lombok.Getter;

@Getter
public class CreateUserForm {
   

  
    private UserCategoryEnum category;
   
    private String name;

    private String document;

 
    private LocalDate birthday;

    
    private String email;
    private String telephone;
    private String password;



}