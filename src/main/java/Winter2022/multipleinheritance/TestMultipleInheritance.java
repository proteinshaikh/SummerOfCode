package Winter2022.multipleinheritance;

public class TestMultipleInheritance implements Father, Mother {
    @Override
    public String son() {
        return "I am Son method";
    }

    @Override
    public String stepson() {
        return Mother.super.stepson();
    }

    public static void main(String[] args) {
        TestMultipleInheritance test = new TestMultipleInheritance();
        System.out.println(test.son());
        System.out.println(test.stepson());
    }
}
