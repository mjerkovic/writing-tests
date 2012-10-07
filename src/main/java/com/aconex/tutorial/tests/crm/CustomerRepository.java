package com.aconex.tutorial.tests.crm;

import java.util.Collection;

public class CustomerRepository {

    private CustomerDAO customerDAO;

    public CustomerRepository() {
        customerDAO = new CustomerDAO();
    }

    public Customer getCustomerById(int customerId) {
        return customerDAO.getCustomerById(customerId);
    }

    public Collection<Customer> getCustomersByLastName(String lastName) {
        return customerDAO.getCustomersByLastName(lastName);
    }

}
