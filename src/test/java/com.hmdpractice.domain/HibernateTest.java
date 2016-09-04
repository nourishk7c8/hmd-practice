package com.hmdpractice.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by developer on 9/3/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "classpath:storefront.xml"
})

@Transactional
public class HibernateTest {

//    @Autowired
//    private ApplicationContext context;
    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback( value = false)
    public void testCreate() {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = new Customer();
        customer.setFirstname("Nourish");
        customer.setLastName("Khan");
        customer.setEmail("nk@gmail.com");

        session.save(customer);
    }

}
