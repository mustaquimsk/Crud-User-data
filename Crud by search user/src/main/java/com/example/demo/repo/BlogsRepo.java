package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Blogs;

public interface BlogsRepo extends CrudRepository<Blogs, Integer> {

}
