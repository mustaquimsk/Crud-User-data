package com.example.demo.controllers;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Address;
import com.example.demo.models.Blogs;
import com.example.demo.models.User;
import com.example.demo.services.UserServices;
import com.example.demo.wraapers.ResponseWrapper;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserServices userServices;
	
	@GetMapping("")
	public ResponseEntity getAllUsers(){
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg("all users");
		reWrapper.setData(this.userServices.getAllUsers());
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity getUserById(@PathVariable int id) {
		
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg(" users");
		reWrapper.setData(this.userServices.getUserById(id));
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@GetMapping("/find-by")
	public ResponseEntity getUserByEmail(@RequestParam String email){
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg("all user");
		reWrapper.setData(this.userServices.getUserByEmail(email));
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@GetMapping("/find-by-Any")
	public ResponseEntity getUserByAnyEmail(@RequestParam String email){
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg(" user");
		reWrapper.setData(this.userServices.getUserByAnyEmail(email));
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@GetMapping("/find-by-name")
	public ResponseEntity getUserByName(@RequestParam(required = false) String name,@RequestParam(required = false)String email){
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg("all user");
		reWrapper.setData(this.userServices.getUserByName(name));
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@GetMapping("/find-by-nameOrEmail")
	public ResponseEntity getUserByNameOrEmail(@RequestParam(required = false) String name,@RequestParam(required = false)String email){
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg("all user");
		reWrapper.setData(this.userServices.getUserByEmailAndName(name,email));
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity getUserByNameOrEmail1(@RequestParam(required = false) String name,@RequestParam(required = false)String email){
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg("all user");
		reWrapper.setData(this.userServices.getUserByEmailAndName(name,email));
		return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity CreateUser(@RequestBody User user) {
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg(" users created succesfully");
		reWrapper.setData(this.userServices.createUser(user));
		
		return new ResponseEntity (reWrapper,HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		
		this.userServices.deleteUser(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("{id}")
	public ResponseEntity updateUser(@PathVariable int id,@RequestBody User updatedata) {
		
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg(" users updated succesfully");
		reWrapper.setData(this.userServices.updateUser(id,updatedata));
        return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@PostMapping("/{id}/address")
	public ResponseEntity address(@PathVariable int id,@RequestBody Address address) {
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg(" address added succesfully");
		reWrapper.setData(this.userServices.createAddress(id, address));
        return new ResponseEntity(reWrapper,HttpStatus.OK);
	}
	
	@PostMapping("/{id}/blogs")
	public ResponseEntity addBlogs(@PathVariable int id,@RequestBody Blogs blogs) {
		ResponseWrapper reWrapper=new ResponseWrapper();
		reWrapper.setMsg(" blog added succesfully");
		reWrapper.setData(this.userServices.createBlogs(id, blogs));
        return new ResponseEntity(reWrapper,HttpStatus.OK);
	}

}
