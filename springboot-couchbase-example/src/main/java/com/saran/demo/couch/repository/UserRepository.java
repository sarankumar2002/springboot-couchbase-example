package com.saran.demo.couch.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.saran.demo.couch.view.User;

@Repository
@ViewIndexed(designDoc = "user", viewName = "all")
public interface UserRepository extends CouchbaseRepository<User, String> {

	List<User> findAll();

	//List<User> findByName(String name);
	
	User deleteById(String id);
	
}
