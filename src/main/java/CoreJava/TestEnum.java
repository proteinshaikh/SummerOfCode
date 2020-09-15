package CoreJava;

public class TestEnum{
    public static void main(String[] args) {
        System.out.println(Planet.MERCURY==Planet.VENUS);
    }
}

 enum Planet {
    MERCURY, VENUS,EARTH
}
