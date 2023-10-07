package Summer2023.c;

/**
 * Represents a class that restricts its instantiation to a maximum of two instances.
 * <p>
 * The {@code LimitedInstancesClass} provides a way to create instances of itself
 * but throws a {@code RuntimeException} if an attempt is made to create more than two instances.
 * </p>
 *
 * <strong>Usage:</strong>
 * <pre>
 * {@code
 * LimitedInstancesClass obj1 = LimitedInstancesClass.createInstance();
 * LimitedInstancesClass obj2 = LimitedInstancesClass.createInstance();
 * // The next line will throw an exception
 * // LimitedInstancesClass obj3 = LimitedInstancesClass.createInstance();
 * }
 * </pre>
 * <p>
 * Note: This restriction assumes a single ClassLoader environment.
 *
 * @author proteinshaikh
 * @version 1.0
 */
public class LimitedInstancesClass {

    private static final int MAX_INSTANCES = 2;
    private static int instanceCount = 0;

    // Private constructor
    private LimitedInstancesClass() {
        if (instanceCount >= MAX_INSTANCES) {
            throw new RuntimeException("Only two instances of this class can be created");
        }
        instanceCount++;
    }

    /**
     * Factory method to create and return instances of {@code LimitedInstancesClass}.
     *
     * @return A new instance of {@code LimitedInstancesClass} if the maximum limit hasn't been reached.
     * @throws RuntimeException if more than two instances are attempted to be created.
     */
    public static LimitedInstancesClass createInstance() {
        return new LimitedInstancesClass();
    }

    /**
     * Resets the count of instances.
     * This might be useful in scenarios where the existing instances have been discarded and new instances need to be created.
     */
    public static void resetInstanceCount() {
        instanceCount = 0;
    }
}
