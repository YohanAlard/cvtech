package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
