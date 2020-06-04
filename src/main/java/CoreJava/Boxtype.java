package CoreJava;

public class Boxtype {
    public void boxtype(int n) throws lessthantenexception {
        if (n < 10) {
            throw new lessthantenexception("Number is less than 10");
        }
    }

    public static void main(String[] args) throws lessthantenexception {
        Boxtype bx = new Boxtype();
        bx.boxtype(5);
    }
}

class lessthantenexception extends Exception {
    public lessthantenexception(String s) {
        super(s);
    }
}




