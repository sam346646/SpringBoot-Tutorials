package com.sam.SpringTestTechademy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sam.SpringTestTechademy.model.Contact;
import com.sam.SpringTestTechademy.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)  //To run only service and its dependencies (controller is not executed)
class SpringTestTechademyApplicationTests {

	@Autowired
	private ContactService contactService;
	
	@Test
	public void testAddContactHappyPath() {
		
		//Create contact
		Contact contact=new Contact();
		contact.setFirstname("sam");
		contact.setLastname("manasseh");
		
		//Test adding the contact
		Contact responseContact = contactService.add(contact);
		
		//Verify
		assertNotNull(responseContact);
		assertNotNull(responseContact.getId());
		assertEquals("sam", responseContact.getFirstname());
	}
}
