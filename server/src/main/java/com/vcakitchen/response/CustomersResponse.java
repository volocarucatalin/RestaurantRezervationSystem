package com.vcakitchen.response;

import com.vcakitchen.entity.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomersResponse implements Serializable {

    List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
