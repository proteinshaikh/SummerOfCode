package Java8.mapflatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    public List<Customer> getCustomerDetails() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("zee", Arrays.asList(123, 456)));
        customers.add(new Customer("zee", Arrays.asList(123, 456)));
        customers.add(new Customer("zee", Arrays.asList(123, 456)));
        customers.add(new Customer("zee", Arrays.asList(123, 456)));

        return customers;

    }
}
