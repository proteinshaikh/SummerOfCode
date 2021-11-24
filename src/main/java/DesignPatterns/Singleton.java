package DesignPatterns;

public class Singleton {

    Singleton singleton = null;

    Singleton anyMethod() {
        if (singleton == null) {
            return new Singleton();
        } else return null;
    }
}
