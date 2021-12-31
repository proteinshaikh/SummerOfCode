package Java8.mapflatmap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();

        List<Customer> customer = customerRepository.getCustomerDetails();


        //map : print list of names

        List<String> names = customer.stream().map(customer1 -> customer1.getName()).collect(Collectors.toList());
        System.out.println(names);

        //map : print list of phones

        List<List<Integer>> phones = customer.stream().map(customer1 -> customer1.getPhone()).collect(Collectors.toList());
        System.out.println(phones);

        //flatmap : print list of phones

        List<Integer> flatphonenos = customer.stream().flatMap(customer1 -> customer1.getPhone().stream()).collect(Collectors.toList());
        System.out.println(flatphonenos);


    }
}
