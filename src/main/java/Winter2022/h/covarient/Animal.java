package Winter2022.h.covarient;

/*
 * Covariant return types in Java refer to the ability of a method in a subclass to override a superclass method such
 * that the return type of the overriding method in the subclass is a subtype (subclass or derived type) of the return
 * type of the overridden method in the superclass.
 * */
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

class TestCovariant {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Animal animal = new Animal();
        System.out.println(tiger.getAnimal());
        System.out.println(animal.getAnimal());
    }
}
