package com.frankie.demo;

import com.frankie.demo.domain.Consultant;
import com.frankie.demo.repository.mysql.contacts.ContactsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ContactsMapper contactsMapper;

    @Test
    public void insertConsultantTest() {
        Consultant consultant = new Consultant();
        consultant.setContactId(972);
        consultant.setName("asan");
        contactsMapper.insertConsultant(consultant);
    }

    @Test
    public void getConsultantTest(){
        Consultant consultant = contactsMapper.getConsultantById(972L);

    }

}
