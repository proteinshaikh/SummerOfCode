package Winter2022.h.abstractsStaticAndConstructor;

abstract class MyAbstractClass {

    int x;

    public MyAbstractClass(int x) {
        this.x = x;
    }

    public static void myStaticMethod() {
        System.out.println("this is the static method from MyAbstractClass");
    }

    public abstract void myAbstractMethod();
}

class MySubClass extends MyAbstractClass {

    public MySubClass(int x) {
        super(x);
    }

    @Override
    public void myAbstractMethod() {
        System.out.println("this is implemented method in MySubClass");
    }

    //static methods in abstract classes can also be overridden in subclasses.
    public static void myStaticMethod() {
        System.out.println("this is the overridden static method from MySubClass");
    }

    //instantiating subclass
    public static void main(String[] args) {
        MySubClass mySubClass = new MySubClass(5);

        System.out.println(mySubClass.x);
        mySubClass.myAbstractMethod();
        MyAbstractClass.myStaticMethod();
        MySubClass.myStaticMethod();
    }
}
