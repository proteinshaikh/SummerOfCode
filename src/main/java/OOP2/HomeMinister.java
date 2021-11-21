package OOP2;

public class HomeMinister extends PrimeMinister{
    public HomeMinister(String role) {
        super(role);
    }

    public HomeMinister(String name, int netWorth, String role) {
        super(name, netWorth, role);
    }

    private String nativeState;

    public String getNativeState() {
        return nativeState;
    }

    public void setNativeState(String nativeState) {
        this.nativeState = nativeState;
    }
}
