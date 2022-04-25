package CoreJava;

/*
 * this variable refers to the instance variable (the variable declared at class level)
 * */
public class Access {
    private int x = 0;
    private int y = 0;

    public static void main(String[] args) {
        Access access = new Access();
        access.printThis(1, 2);
        System.out.println();
        access.printThat(3, 4);
    }

    private void printThis(int x, int y) {
        System.out.println("printThis method invoked");
        System.out.println("x: " + this.x + " " + " y: " + this.y);
    }

    private void printThat(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("printThat method invoked");
        System.out.println("x: " + this.x + " " + " y: " + this.y);
    }
}
