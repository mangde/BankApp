/*
 * COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.model.customermodel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

    @NotNull
    @Size(min=5, message="Name should have atleast 5 characters")
    private final String name;
    @Size(min=10,max=10,message = "phone should contain 10 digit number")
    @Pattern(regexp="(^$|[0-9]{10})")
    private final long phone;
    @Size(min=5, message="ADDRESS should have atleast 5 characters")
    private final String address;
    @Size(min=5, message="CityName should have atleast 5 characters")
    private final String city;
    @Id
    @GeneratedValue
    private int id;

    public Customer(String name, Long phone, String address, String city) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id + ", name='" + this.name + '\'' + ", phone=" + this.phone + ", address='" + this.address + '\'' + ", city='" + this.city + '\'' + '}';
    }
}
