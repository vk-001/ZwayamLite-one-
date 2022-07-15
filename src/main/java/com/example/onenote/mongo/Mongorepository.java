package com.example.onenote.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface Mongorepository extends MongoRepository<Notedata, String>{
	
	@Query(value = "{'_id' : ObjectId('?0')}", delete = true)
	void deleteById(String id);
	
	@Query("{created_by:'?0'}")
	Notedata findNoteByEmail(String email);
	
	@Query("{created_by:'?0'}")
	Iterable<Notedata> findNoteByCreated_by(String created_by);

}
