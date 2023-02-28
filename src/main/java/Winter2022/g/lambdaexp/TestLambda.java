package Winter2022.g.lambdaexp;

public class TestLambda {
    public static void main(String[] args) {
        Student student = str -> 5;
        System.out.println(student.getRollNum("123"));

        Student2 student2 = y -> "test";
        System.out.println(student2.getName(123));
    }
}
