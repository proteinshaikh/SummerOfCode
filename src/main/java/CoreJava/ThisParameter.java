package CoreJava;

public class ThisParameter {

    public static void main(String[] args) {
        ThisParameter thisParameter = new ThisParameter();
        thisParameter.get();
    }

    int a;
    int b;

    ThisParameter() {
        a = 10;
        b = 20;
    }

    void display(ThisParameter thisParameter) {
        System.out.println("a= " + thisParameter.a + " b= " + thisParameter.b);
    }

    void get() {
        display(this);
    }
}
