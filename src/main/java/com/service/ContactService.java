package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.*;
import com.entity.*;
import java.util.List;

@Service
public class ContactService {

	// Create Read Update Delete
	// Create
	@Autowired
	private ContactDao contactDao;

	// Create Update
	public Contact SaveOrUpdate(Contact contact) {

		return this.contactDao.save(contact);
	}
	
	public List<Contact> saveAll(List<Contact> contacts){
		return this.contactDao.saveAllAndFlush(contacts);
	}

	// Read
	public List<Contact> getAllContacts() {
		return this.contactDao.findAll();
	}
	public Contact getById(int id) {
		try {
		return this.contactDao.findById(id).get();}
		catch(Exception e) {
			System.out.println("No Contact Found With Given Id");
			return null;
		}
	}

	
	// Delete
	public boolean deleteById(int id) {
		try {
			Contact c=getById(id);
			if(c==null) {
				System.out.println("No Contact With Such Id present");
				return false;
			}
			this.contactDao.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
