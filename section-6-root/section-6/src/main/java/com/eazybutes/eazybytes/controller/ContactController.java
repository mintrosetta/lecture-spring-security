package com.eazybutes.eazybytes.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.Contact;
import com.eazybutes.eazybytes.repository.ContactRepository;

@RestController
@RequestMapping("contacts")
public class ContactController {

	private ContactRepository contactRepository;

	public ContactController(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
    @PostMapping("")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
    	contact.setContactId(getServiceReqNumber());
    	contact.setCreateDt(new Date(System.currentTimeMillis()));
    	
    	return this.contactRepository.save(contact);
    }
    
    private String getServiceReqNumber() {
    	Random random = new Random();
    	
    	int randomNumber = random.nextInt(999999999 - 9999) + 9999;
    	
        return "SR" + randomNumber;
    }

}
