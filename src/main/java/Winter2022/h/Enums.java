package Winter2022.h;

public abstract class Enums {

    public enum ACCOUNT_TYPES{
        SAVINGS("savings"),
        CURRENT("current"),
        LOAN ("loan");

        private String name;

        ACCOUNT_TYPES(String name) {
            this.name = name;
        }
    }
}
