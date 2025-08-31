package se.plweb.rest_demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository implements Repository<Customer> {
    private final List<Customer> customerList = new ArrayList<>();

    public CustomerRepository() {

    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public Customer get(int i) {
        return customerList.get(i);
    }

}
