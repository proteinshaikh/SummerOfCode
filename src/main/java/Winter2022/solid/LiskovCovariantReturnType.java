package Winter2022.solid;

public class LiskovCovariantReturnType {
    public static void main(String[] args) {
        IntegerProducer integerProducer = new IntegerProducer();
        System.out.println(integerProducer.produce("123"));
    }
}

class Producer {
    public Object produce(String string) {
        String result = string.toLowerCase();
        return result;
    }
}

class IntegerProducer extends Producer {

    public Integer produce(String string) {
        return Integer.parseInt(string);
    }

}
