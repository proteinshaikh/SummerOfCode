package OOP2;

public class Main {

    public static void main(String[] args) {
        ministry();
    }

    public static String ministry(){
        PrimeMinister primeMinister = new PrimeMinister("homeMinistry");
        return primeMinister.getRole();
    }
}
