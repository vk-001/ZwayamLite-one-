package com.example.onenote.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mongoservice {
	
	@Autowired
    Mongorepository mongorepo;
	
	public void createNote(Notedata notedata) {
		mongorepo.save(notedata);
	}
	
	public Notedata getById(String id) {
		return mongorepo.findById(id).orElse(null);
	}
	
	public Notedata getByEmail(String email) {
        return mongorepo.findNoteByEmail(email);
    }
	
	public Iterable<Notedata> listAll() {
        return mongorepo.findAll();
    }
		
	public Iterable<Notedata> findbycreated(String created_by){
		return mongorepo.findNoteByCreated_by(created_by);
	}
	
	public void delete(String id) {
		mongorepo.deleteById(id);
    }
}
