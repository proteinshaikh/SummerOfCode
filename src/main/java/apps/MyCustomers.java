package apps;

import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class MyCustomers {

    public static void main(String[] args) {
        System.out.println(isValidCustomerName("J"));
        System.out.println(isValidBikeNo("AP31CW3008"));
        System.out.println(isValidServiceDate(LocalDate.now().minusDays(1)));

    }

    public static boolean isValidCustomerName(String customerName){

        boolean isValidCustomer = false;

        if(!StringUtils.isEmpty(customerName)){
        isValidCustomer = customerName.matches("(^\\b[A-Z][a-z]*){1,}+\\b$");
        }

        return isValidCustomer;

    }

    public static boolean isValidBikeNo(String bikeNo) {

        boolean isValidbikeNo = false;

        if (!StringUtils.isEmpty(bikeNo)) {
            isValidbikeNo = bikeNo.matches("[0-9]{10,10}");
        }

        return isValidbikeNo;

    }

    public static boolean isValidServiceType(String serviceType) {

        boolean isValidServiceType = false;

        if (!StringUtils.isEmpty(serviceType)) {
            if (serviceType.equals("General") || serviceType.equals("Express")) {
                isValidServiceType = true;
            }
        }

        return isValidServiceType;

    }

    public static boolean isValidPhoneNo(Long phoneNo) {

        String str = String.valueOf(phoneNo);

        boolean isValidPhoneNo = false;

        if (!StringUtils.isEmpty(phoneNo)) {
            isValidPhoneNo = str.matches("[0-9]{10,10}");
        }

        return isValidPhoneNo;

    }

    public static boolean isValidServiceDate(LocalDate lastServiceDate) {

        if (lastServiceDate.isAfter(LocalDate.now())) {
            return false;
        } else {
            return true;
        }
    }

}
