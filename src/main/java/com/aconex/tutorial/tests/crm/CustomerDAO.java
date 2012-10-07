package com.aconex.tutorial.tests.crm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class CustomerDAO {

    private final Map<Integer, Customer> idMap = new HashMap<Integer, Customer>();
    private final Multimap<String, Customer> lastNameMap = HashMultimap.create();

    public CustomerDAO() {
        buildCustomerMaps();
    }

    public Customer getCustomerById(int customerId) {
        if (idMap.containsKey(customerId)) {
           return idMap.get(customerId);
        }
        throw new IllegalArgumentException("No customer exists for the given ID");
    }

    public Collection<Customer> getCustomersByLastName(String lastName) {
        if (lastNameMap.containsKey(lastName)) {
           return lastNameMap.get(lastName);
        }
        throw new IllegalArgumentException("No customers exist for the given last name");
    }

    private void buildCustomerMaps() {
        int customerId = 0;
        String allCustomers = "Tom Cruise,Patrick O'Leary,Tim Yeung,Sally Major,Bob Smith,Maggie Smith";
        for (String customerName : Splitter.on(",").split(allCustomers)) {
            Iterator<String> names = Splitter.on(" ").split(customerName).iterator();
            Customer customer = new Customer(++customerId, names.next(), names.next());
            idMap.put(customer.getCustomerId(), customer);
            lastNameMap.put(customer.getLastName(), customer);
        }
    }
}
