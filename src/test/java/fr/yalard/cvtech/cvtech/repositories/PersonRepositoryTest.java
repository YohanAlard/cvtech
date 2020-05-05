package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Address;
import fr.yalard.cvtech.cvtech.model.sql.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;


class PersonRepositoryTest extends AbstractRepositoryTest<Person, PersonRepository> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        Address address = Address.builder().streetAddress("1 rue de la soif")
                .city("maubeuge")
                .postalCode("59600")
                .build();
        person.setAddress(address);
    }

    @Override
    public Person getObjectToSave() {
        return person;
    }

    @Override
    public PersonRepository getRepository() {
        return personRepository;
    }

    @Test
    public void checkCascadeCreationDeletionWithAddress() {
        Person personSaved = personRepository.save(person);
        personRepository.deleteById(personSaved.getId());
        assertFalse(addressRepository.existsById(personSaved.getAddress().getId()));
    }
}