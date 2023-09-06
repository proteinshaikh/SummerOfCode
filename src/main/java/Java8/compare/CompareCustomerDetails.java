package Java8.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
 * list of customer -> name, accttype, acctno, branchname, city
 * sort based on accttype, branchname nad group by branch name
 *
 * */

public class CompareCustomerDetails {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Zeeshan", "savings", 123, "Grant Road", "mumbai"));
        customers.add(new Customer("Shaikh", "current", 222, "Bhindi bazar", "mumbai"));
        customers.add(new Customer("AKram", "savings", 010, "Mahim", "mumbai"));
        customers.add(new Customer("Test", "current", 2, "Arthur Road", "mumbai"));
        customers.add(new Customer("Alpha", "savings", 10, "Arthur Road", "mumbai"));

        //sorting based on accountType
        List<Customer> sortByAccountType = customers.stream().sorted(Comparator.comparing(Customer::getAccountType)).toList();
        System.out.println("sorting by account type: " + sortByAccountType);

        //sorting based on branch name
        List<Customer> sortByBranchName = customers.stream().sorted(Comparator.comparing(Customer::getBranchName)).toList();
        System.out.println("sorting by branch name: " + sortByBranchName.toString());


        //sort by accountType and branch name
        List sortByBranchNameAndAccountType = customers.stream().sorted(Comparator.comparing(Customer::getAccountType).
                thenComparing(Customer::getBranchName)).toList();
        System.out.println("sorting by account type and branch name: " + sortByBranchNameAndAccountType);


        //sort by accountType and branch name and group customers by branch name
        Map<String, Set<Customer>> sortByBranchNameAndAccountTypeAndGroupByBranchName = customers.stream().sorted(Comparator.comparing(Customer::getAccountType).
                thenComparing(Customer::getBranchName)).collect(Collectors.groupingBy(Customer::getBranchName, Collectors.toSet()));
        System.out.println("sorting by account type and branch name and grouping by branch name: " + sortByBranchNameAndAccountTypeAndGroupByBranchName.toString());
    }
}
