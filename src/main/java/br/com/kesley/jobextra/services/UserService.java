package br.com.kesley.jobextra.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.kesley.jobextra.controller.Form.CreateUserForm;
import br.com.kesley.jobextra.controller.Form.UpdateCompanyForm;
import br.com.kesley.jobextra.controller.Form.UpdatePersonForm;
import br.com.kesley.jobextra.exception.UnsufficientDataException;
import br.com.kesley.jobextra.models.Company;
import br.com.kesley.jobextra.models.Person;
import br.com.kesley.jobextra.models.User;
import br.com.kesley.jobextra.models.UserCategoryEnum;
import br.com.kesley.jobextra.repository.UserRepository;
import br.com.kesley.jobextra.util.PasswordUtil;
@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public List<User> findAllByName(String name){
       return repository.findAllByNameContainingIgnoreCase(name);
    }

    public User findById(Integer id){
        Optional<User> p = repository.findById(id);

        if(p.isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
        return p.get();
    }

    public User create(CreateUserForm form) {
        try {
        validateCreateForm(form);
        } catch (UnsufficientDataException e) {
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        
        User user;
            if (form.getCategory() == UserCategoryEnum.INDIVIDUAL) {
                user = createPerson(form);
            } else if (form.getCategory() == UserCategoryEnum.CORPORATE) {
            user = createCompany(form);
            } 
            else {
                throw new IllegalArgumentException("Tipo de usuário inválido!");
            }
            return repository.save(user);
        }
        
        private User createPerson(CreateUserForm form) {
            Person p = new Person();
            p.setBirthday(form.getBirthday());
            
            return createUserData(p, form);
            }
            
            private User createCompany(CreateUserForm form) {
           
            return createUserData(new Company(), form);
            }

            private User createUserData(User user, CreateUserForm form){
                user.setName(form.getName());
                user.setDocument(form.getDocument());
                user.setTelephone(form.getTelephone());
                user.setEmail(form.getEmail());
                user.setPassword(PasswordUtil.encrypt(form.getPassword()));
                return user;

            }
        private void validateCreateForm(CreateUserForm form) {
        if (form.getEmail() == null || form.getEmail().isEmpty()) {
        throw new UnsufficientDataException("Email não informado!");
        }
        if (form.getPassword() == null || form.getPassword().isEmpty()) {
        throw new UnsufficientDataException("Senha não informada!");
        }

        
    }
    public byte[] getPhoto(Integer id){
        User p = findById(id);
        return p.getPhoto();
    }

	public Person updatePerson(Integer id, UpdatePersonForm form) {
		return null;
	}

	public Company updateCompany(Integer id, UpdateCompanyForm form) {
		return null;
	}

	public void delete(Integer id) {
        User user = findById(id);

        repository.delete(user);
	}

}