package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.service.*;
import com.entity.*;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/save")
	public Contact save(@RequestBody Contact contact) {
		if(contact.getId()==0||contact.getFirstName()==null||contact.getPhoneNumber()==null) {
			return null;
		}
		System.out.println();
		return this.contactService.SaveOrUpdate(contact);
	}

	@PostMapping("/saveAll")
	public List<Contact> saveAll(@RequestBody List<Contact> contacts) {
		return this.contactService.saveAll(contacts);
	}

	@GetMapping("/getAll")
	public List<Contact> getAllContacts() {
		System.out.println("Method Called");
		return this.contactService.getAllContacts();
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
		boolean b = this.contactService.deleteById(id);
		if (b) {
			return new ResponseEntity<>( HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
}
