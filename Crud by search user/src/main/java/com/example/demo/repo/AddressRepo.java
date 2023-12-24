package com.example.demo.repo;


import org.springframework.data.repository.CrudRepository;



import com.example.demo.models.Address;

public interface AddressRepo extends CrudRepository<Address, Integer>{

	//Address save(AddressRepo address);

}
