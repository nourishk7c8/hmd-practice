package com.hmdpractice.domain;

import javax.persistence.*;

/**
 * Created by developer on 9/6/2016.
 */
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ORDER_ID")
    private Order order;
    @Column(name="ITEM_NAME")
    private String itemName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (getId() != null ? !getId().equals(orderItem.getId()) : orderItem.getId() != null) return false;
        if (getOrder() != null ? !getOrder().equals(orderItem.getOrder()) : orderItem.getOrder() != null) return false;
        return getItemName() != null ? getItemName().equals(orderItem.getItemName()) : orderItem.getItemName() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
        result = 31 * result + (getItemName() != null ? getItemName().hashCode() : 0);
        return result;
    }
}
