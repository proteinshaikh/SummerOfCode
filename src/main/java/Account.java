public class Account {
    private final String customerName;
    private final int customerId;
    private final String state;
    private final String businessUnit;

    Account(String customerName, int customerId, String state, String businessUnit) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.state = state;
        this.businessUnit = businessUnit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getState() {
        return state;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerName='" + customerName + '\'' +
                ", customerId=" + customerId +
                ", state='" + state + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                '}';
    }
}
