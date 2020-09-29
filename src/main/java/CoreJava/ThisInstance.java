package CoreJava;

public class ThisInstance {
    public static void main(String[] args) {
        ThisInstance thisInstance = new ThisInstance();
        thisInstance.get().display();
    }

    int a;
    int b;

    ThisInstance() {
        a = 10;
        b = 20;
    }

    ThisInstance get() {
        return this;
    }

    void display() {
        System.out.println("a= " + a + "b= " + b);
    }
}
