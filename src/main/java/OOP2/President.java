package OOP2;

public class President {

    public President() {
    }

    public President(String name, int netWorth) {
        this.name = name;
        NetWorth = netWorth;
    }

    private String name;
    private int NetWorth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNetWorth() {
        return NetWorth;
    }

    public void setNetWorth(int netWorth) {
        NetWorth = netWorth;
    }
}
