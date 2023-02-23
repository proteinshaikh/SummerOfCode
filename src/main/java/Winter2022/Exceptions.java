package Winter2022;

public class Exceptions {
    public static void main(String[] args) {

    }

    static void throwsMethod(int num) throws Exception {
        if (num > 5) {
            System.out.println("from throws method: " + num);
        } else {
            throw new Exception();
        }

    }
}
