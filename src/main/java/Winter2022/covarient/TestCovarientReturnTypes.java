package Winter2022.covarient;

class Animal {
    public Animal getAnimal(){
        return this;
    }
}

class Cat extends Animal{
    public Cat getAnimal(){
        return this;
    }
}

public class TestCovarientReturnTypes{
Cat cat = new Cat();
Animal animal = cat.getAnimal();
}
