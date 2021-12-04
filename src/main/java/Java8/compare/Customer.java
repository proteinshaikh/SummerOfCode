package Java8.compare;


public class Customer {
    private String name;
    private String accountType;
    private int accountNumber;
    private String branchName;
    private String city;

    public Customer() {
    }

    public Customer(String name, String accountType, int accountNumber, String branchName, String city) {
        this.name = name;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.branchName = branchName;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", accountType='").append(accountType).append('\'');
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", branchName='").append(branchName).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
