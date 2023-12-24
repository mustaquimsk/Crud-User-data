package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;
import com.example.demo.projection.UserProjection;
import java.util.List;


public interface UserRepo extends CrudRepository<User, Integer> {
	
	public Iterable<UserProjection>findAllUserBy();
	
	public Optional<UserProjection>findUserById(int id);
	
	public Optional<UserProjection> findByEmail(String email);
	
	public Iterable<UserProjection> findByEmailContaining(String email);
	
	public Iterable<UserProjection>findByName(String name);
	
	public Iterable<UserProjection>findByNameOrEmail(String name,String eamil);
	
	public Iterable<UserProjection>findByNameContainingOrEmailContaining(String name,String email);

}
