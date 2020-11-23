package learn.junitia.ch02core.tags;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final List<Customer> customers = new ArrayList<>();

    public boolean contains(String name) {
        return customers.stream().anyMatch(customer -> customer.getName().equals(name));
    }

    public void persist(Customer customer) {
        customers.add(customer);
    }
}
