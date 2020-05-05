package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Address;
import org.springframework.beans.factory.annotation.Autowired;

class AddressRepositoryTest extends AbstractRepositoryTest<Address, AddressRepository> {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getObjectToSave() {
        return new Address();
    }

    @Override
    public AddressRepository getRepository() {
        return addressRepository;
    }
}