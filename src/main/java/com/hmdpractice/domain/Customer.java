package com.hmdpractice.domain;


import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer{
    @Id
    @GeneratedValue
    @Column (name="CUSTOMER_ID")
    private  Long id;
    @Column(name = "FISRT_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column (name = "EMAIL")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}