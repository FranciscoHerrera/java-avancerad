package se.coredev.repository;

import org.springframework.data.repository.CrudRepository;

import se.coredev.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
