package br.com.kesley.jobextra.config;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.kesley.jobextra.models.Application;
import br.com.kesley.jobextra.models.Company;
import br.com.kesley.jobextra.models.Course;
import br.com.kesley.jobextra.models.CourseDurationEnum;
import br.com.kesley.jobextra.models.CourseStatusEnum;
import br.com.kesley.jobextra.models.CourseType;
import br.com.kesley.jobextra.models.Curriculum;
import br.com.kesley.jobextra.models.Institution;
import br.com.kesley.jobextra.models.Job;
import br.com.kesley.jobextra.models.JobExperience;
import br.com.kesley.jobextra.models.JobStatusEnum;
import br.com.kesley.jobextra.models.Person;
import br.com.kesley.jobextra.repository.ApplicationRepository;
import br.com.kesley.jobextra.repository.CourseRepository;
import br.com.kesley.jobextra.repository.CourseTypeRepository;
import br.com.kesley.jobextra.repository.CurriculumRepository;
import br.com.kesley.jobextra.repository.InstitutionRepository;
import br.com.kesley.jobextra.repository.JobExperienceRepository;
import br.com.kesley.jobextra.repository.JobRepository;
import br.com.kesley.jobextra.repository.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CurriculumRepository curriculumRepository;
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobExperienceRepository jobExperienceRepository;
    @Override
    public void run(String... args) throws Exception {
        // Adição de dados iniciais no banco de dados
        Person john = new Person();
        john.setName("Jhon");

        john.setDocument("12345678901");
        john.setEmail("john@gmail.com");
        john.setBirthday(LocalDate.of(1990, 03, 06));
        john.setTelephone("32244000");
        john.setPassword("123456");
        
        Company barDoZe = new Company();
        barDoZe.setName("Bar do Zé");
        barDoZe.setDocument("11111111111");
        barDoZe.setEmail("barDOZe@gmail.com");

        barDoZe.setTelephone("32244000");
        barDoZe.setPassword("1234567");
        
        userRepository.saveAll(List.of(john, barDoZe));
        
        // Tipos de curso
        CourseType medio = new CourseType();
        medio.setDescription("Ensino Médio");
        
        CourseType graduacao = new CourseType();
        graduacao.setDescription("Graduação");
        
        CourseType pos = new CourseType();
        pos.setDescription("Pós-Graduação");
        
        courseTypeRepository.saveAll(List.of(medio, graduacao, pos));
//curriculum
// Curriculum
Curriculum curriculum = new Curriculum();
curriculum.setSummary("Eu sou mais eu");
curriculum.setPerson(john);

curriculumRepository.save(curriculum);

// Instituição
Institution senac = new Institution();
senac.setName("SENAC");

institutionRepository.save(senac);

// Curso
Course tecnico = new Course();
tecnico.setName("Técnico em bebidas");
tecnico.setType(medio);
tecnico.setDuration(CourseDurationEnum.AVERAGE);
tecnico.setStatus(CourseStatusEnum.FINISHED);
tecnico.setInstitution(senac);
tecnico.setCurriculum(curriculum);

    courseRepository.save(tecnico);


    JobExperience job = new JobExperience();
    job.setCompanyName("Boteco Praton Bar");
    job.setDescription("Atendimento de pessoas servindo bebidas");
    job.setStartDate(LocalDate.of(2020, 05, 20));
    job.setResignationDate(LocalDate.of(2020, 05, 21));
    job.setCurriculum(curriculum);

    jobExperienceRepository.save(job);
    
    // Vagas de meprego

    Job garcon = new Job();
    garcon.setDescription("Atendimento aos clientes, servir bebidas e controlar lista de pedidos");
    garcon.setJobDay(LocalDate.of(2020, 05, 23));
    garcon.setOwner(barDoZe);
    garcon.setJobStatus(JobStatusEnum.OPEN);
    garcon.setValue(100.0);

    jobRepository.save(garcon);

    //candidatura John para vaga Garçon

    
    
    Application application = new Application(garcon, john);
    
    applicationRepository.save(application);
    
    garcon.getApplications().add(application);
    
    jobRepository.save(garcon);

    
    
    }
    
}