package com.hmdpractice.domain;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback( value = false)
    public void testCreate() {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = new Customer();
        customer.setFirstName("Nourish");
        customer.setLastName("Khan");
        customer.setEmail("nk@gmail.com");

        session.save(customer);
    }

    @Test
    @Rollback (value = false)
    public void testOrder(){

        Session session = sessionFactory.getCurrentSession();

        Order order = new Order();
        order.setDateCreated(LocalDateTime.now());

        Customer customer = new Customer();
        customer.setFirstName("Nina");
        customer.setLastName("Khan");
        customer.setEmail("nk@gmail.com");

        order.setCustomer(customer);

        session.setHibernateFlushMode(FlushMode.MANUAL);

        session.save(customer);
        session.save(order);



        OrderItem orderItem = new OrderItem();
        orderItem.setItemName("A");


        OrderItem orderItemB = new OrderItem();
        orderItemB.setItemName("B");

        OrderItem orderItemC = new OrderItem();
        orderItemC.setItemName("C");

        session.save(orderItem);
        session.save(orderItemB);
        session.save(orderItemC);

        order.addItem(orderItem);
        order.addItem(orderItemB);
        order.addItem(orderItemC);

        session.save(order);
        session.flush();

        //session.flush();

    }


}
