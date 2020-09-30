package CoreJava;

public class NestedClass {
    public static void main(String[] args) {
        //printing message from static class
        OuterClass.StaticNested printer=new OuterClass.StaticNested();
        printer.printmessage();

        //printing message from inner class
        OuterClass.InnerClass inner=new OuterClass().new InnerClass();
        inner.display();
    }
}

class OuterClass{
    private static String message="Hello";

    public static class StaticNested{
        public void printmessage(){
            System.out.println("message from static class :" +message);
        }
    }

    public class InnerClass{
        public void display(){
            System.out.println("message from inner class "+message);
        }
    }
}
