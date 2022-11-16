import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

        List<Company> companyList = new ArrayList<>();

        companyList.add(new Company("lti"));
        companyList.add(new Company("ibm"));
        Person person = new Person("zee", 25, companyList);


        List<Company> companyList1;
        companyList1 = person.getCompanies();
        if(Objects.nonNull(companyList1) && !CollectionUtils.isEmpty(companyList1)){
            Person person1 = new Person("sha", 30, companyList1);
            System.out.println(person1.getCompanies());
        }


    }
}
