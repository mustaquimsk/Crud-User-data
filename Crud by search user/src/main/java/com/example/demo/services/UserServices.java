package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.example.demo.models.Address;
import com.example.demo.models.Blogs;
import com.example.demo.models.User;
import com.example.demo.projection.UserProjection;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.BlogsRepo;
import com.example.demo.repo.UserRepo;

@Service
public class UserServices {
	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;
	@Autowired
	BlogsRepo blogsRepo;

	public User getUserWithPassword(int id) {
		return this.userRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		});

	}

//	public Iterable<User> getAllUser() {
//		return this.userRepo.findAll();
//	}
//
//	public User getUserById(int id) {
//		return this.userRepo.findById(id).orElseThrow(() -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);});
//	}

	public Iterable<UserProjection> getAllUsers() {
		return this.userRepo.findAllUserBy();
	}

	public UserProjection getUserById(int id) {
		return this.userRepo.findUserById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		});
	}

	public UserProjection getUserByEmail(String email) {
		return this.userRepo.findByEmail(email).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		});
	}

	public Iterable<UserProjection> getUserByAnyEmail(String email) {
		return this.userRepo.findByEmailContaining(email);
	}

	public Iterable<UserProjection> getUserByName(String name) {
		return this.userRepo.findByName(name);
	}

	public Iterable<UserProjection> getUserByEmailAndName(String name, String email) {
		return this.userRepo.findByNameOrEmail(name, email);
	}

	public Iterable<UserProjection> getUserByAnyEmailAndName(String name, String email) {
		return this.userRepo.findByNameContainingOrEmailContaining(name, email);
	}

	public User createUser(User user) {
		return this.userRepo.save(user);
	}

	public void deleteUser(int id) {
		this.userRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"User can't delete because Id " + id + " not Found");
		});
		this.userRepo.deleteById(id);
	}

	public User updateUser(int id, User user) {
		User userdata = getUserWithPassword(id);
		user.setId(id);
		user.setCreateDate(userdata.getCreateDate());
		return this.userRepo.save(user);
	}

	public Address createAddress (int id,Address address){
		User userdata = getUserWithPassword(id);
		Address addressdata= this.addressRepo.save(address);
		userdata.setAddress(addressdata);
		this.userRepo.save(userdata);
		return addressdata;
	}
	
	public Address getAddress(int id) {
		User userdata=getUserWithPassword(id);
		return userdata.getAddress();
	}
	public Blogs createBlogs (int id,Blogs blogs){
		User userdata = getUserWithPassword(id);
		blogs.setUser(userdata);
		Blogs saveBlog=this.blogsRepo.save(blogs);
		return saveBlog;
	
	}
}