/*
 * COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.model.customermodel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Customer Model class.
 */
public class Customer {

    private final String name;
    private final long phone;
    private final String address;
    private final String city;
    @Id
    @GeneratedValue
    private int id;

    /**
     * Customer Constructor.
     *
     * @param name name of customer
     * @param phone phone
     * @param address address
     * @param city city
     */
    public Customer(String name, Long phone, String address, String city) {
        this.name = name;
        this.phone = phone.longValue();
        this.address = address;
        this.city = city;
    }

    /**
     * getCustomerId.
     *
     * @return customerId
     */
    public int getId() {
        return id;
    }

    /**
     * setCustomerId.
     *
     * @param id customerId
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get CustomerName.
     *
     * @return CustomerName
     */
    public String getName() {
        return name;
    }

    /**
     * get phone.
     *
     * @return phone
     */
    public long getPhone() {
        return phone;
    }

    /**
     * get Customer address.
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * get city.
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id +
            ", name='" + name + '\'' +
            ", phone=" + phone +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' + '}';
    }
}
