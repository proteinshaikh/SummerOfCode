package Winter2022.h.covarient;

import org.apache.poi.ss.formula.functions.T;

class Animal {

    public String getAnimal() {
        return "instance of Animal class";
    }
}

class Tiger extends Animal {

    public String getAnimal() {
        return "instance of Tiger class";
    }

}

class TestCovarient {
    public static void main(String[] args) {
        Animal animal = new Tiger();
        Tiger tiger = (Tiger) animal;
        System.out.println(tiger.getAnimal());
        System.out.println(animal.getAnimal());
    }
}
