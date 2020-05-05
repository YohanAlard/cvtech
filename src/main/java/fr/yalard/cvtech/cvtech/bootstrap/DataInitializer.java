package fr.yalard.cvtech.cvtech.bootstrap;

import fr.yalard.cvtech.cvtech.model.sql.Person;
import fr.yalard.cvtech.cvtech.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {
    private final PersonRepository personRepository;

    public DataInitializer(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        log.debug("initializing project");
        Person person = new Person();
        person.setFirstName("yohan");
        person.setLastName("alard");
        personRepository.save(person);
    }
}
