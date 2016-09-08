package com.hmdpractice.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order implements Serializable{

    //instance variables
    @Id
    @GeneratedValue
    @Column(name="CUSTOMER_ORDER_ID")
    private Long id;
    @Column(name="DATE_CREATED")
    private LocalDateTime dateCreated;
    @ManyToOne
    @JoinColumn (name="CUSTOMER_ID")
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItemSet = new HashSet<>();


    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void addItem(OrderItem orderItem){
        orderItem.setOrder(this);
        orderItemSet.add(orderItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        if (getCustomer() != null ? !getCustomer().equals(order.getCustomer()) : order.getCustomer() != null)
            return false;
        return getDateCreated() != null ? getDateCreated().equals(order.getDateCreated()) : order.getDateCreated() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getDateCreated() != null ? getDateCreated().hashCode() : 0);
        return result;
    }
}