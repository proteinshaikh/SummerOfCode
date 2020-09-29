package CoreJava;

public class OverridingTest {
    public static void main(String[] args) {
        OverridingTest overridingTest=new OverridingTest();
        System.out.println("This calls parent"+overridingTest.mul(1,2));
        OverridingTest over=new Children();
        System.out.println("This calls child via parent"+over.mul(1,2));

    }
    int mul(int a, int b){
        return a*b;
    }
}

class Children extends OverridingTest{
    @Override
    int mul(int a , int b){
        return a+b;
    }

}
