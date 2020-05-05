package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Person;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;


class PersonRepositoryTest extends AbstractRepositoryTest<Person, PersonRepository> {

    @Autowired
    private PersonRepository personRepository;
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Override
    public Person getObjectToSave() {
        return person;
    }

    @Override
    public PersonRepository getRepository() {
        return personRepository;
    }
}