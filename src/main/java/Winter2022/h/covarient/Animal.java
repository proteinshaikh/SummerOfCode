package Winter2022.h.covarient;


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
        Tiger animal = new Tiger();
        System.out.println(animal.getAnimal());
        System.out.println(animal.getAnimal());
    }
}
