package winter2024;


public class LimitedInstancesClass {

    private static final int MAX_INSTANCES = 2;
    private static int instanceCount = 0;

    private LimitedInstancesClass() {
        if (instanceCount >= MAX_INSTANCES) {
            throw new RuntimeException("Only two instances of this class can be created");
        }
        instanceCount++;
    }

    public static LimitedInstancesClass createInstance() {
        return new LimitedInstancesClass();
    }

    public static void resetInstanceCount() {
        instanceCount = 0;
    }

    public static void main(String[] args) {
        // Usage
        LimitedInstancesClass obj1 = LimitedInstancesClass.createInstance();
        LimitedInstancesClass obj2 = LimitedInstancesClass.createInstance();

        // Uncommenting the next line will throw an exception
        //LimitedInstancesClass obj3 = LimitedInstancesClass.createInstance();
    }
}

