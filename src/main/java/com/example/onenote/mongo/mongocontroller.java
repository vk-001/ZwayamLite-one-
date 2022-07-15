package com.example.onenote.mongo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class mongocontroller {

	
	@Autowired
	private mongoservice service;
	
	@PostMapping(path="/createnote")
	public @ResponseBody String createNewNote(@RequestBody Notedata notedata) {
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String currentDate = dateformat.format(date);  
        notedata.setCreated_date(date);
		service.createNote(notedata);
	    return "Note is created\n";
	}
	
	@GetMapping(path="/findnotes/{created_by}")
	public Iterable<Notedata> findbycreated(@PathVariable String created_by){
		return service.findbycreated(created_by);
	}
	
	@GetMapping("/find/{\n" + 
			"		return repo.save(userdata);\n" + 
			"		email}")
	
	public ResponseEntity<Notedata> get(@PathVariable String email) {
		try{
			Notedata notedata = service.getByEmail(email);
	        return new ResponseEntity<Notedata>(notedata, HttpStatus.OK);
	    }
		catch (NoSuchElementException e) {
	        return new ResponseEntity<Notedata>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@GetMapping("/findid/{id}")
	public Notedata getById(@PathVariable String id) {
		try{
			Notedata note = service.getById(id);
			return note;
		}
		catch(NoSuchElementException e){
			return  null;
		}
	}
	
	
	@DeleteMapping(path="/delete/{id}/{email}")
	public Iterable<Notedata> deleteUser(@PathVariable String id,@PathVariable String email){
		try{
			service.delete(id);
	        return findbycreated(email);
	    } 
		catch (NoSuchElementException e){
	        return null;
	    } 
	}
	
	
}
