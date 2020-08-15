package design_patterns;

public class Singleton {
    public static void main(String[] args) {
        //Get the only object available
        Single single = Single.getInstance();
        single.showMessage();
    }
}

class Single {
    private static Single single = new Single();

    //make the constructor private so that this class cannot be instantiated
    private Single() {

    }

    //Get the only object available
    public static Single getInstance() {
        return single;
    }

    public void showMessage() {
        System.out.println("hello singleton");
    }

}
