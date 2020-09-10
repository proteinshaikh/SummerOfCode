package CoreJava;

public class Overloading {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        Overloading over = new Overloading();
        Overloading over2 =  new Ride();
        System.out.println(over.add(m,n));
        System.out.println(over2.add(m,n));
    }

    public  int add(int a, int b){
        int sum;
        return sum = a+b;
    }

    public  int add(Integer a, Integer b){
        int sum;
        return sum = a+b; 
    }
}

class Ride extends Overloading  {
    public int add(int a, int b){
        int sum;
        return sum = a*b;
    }
}
