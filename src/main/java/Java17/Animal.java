package Java17;

public sealed class Animal permits Cat, Dog, Bird {
    public void eat(){
        System.out.println("Animal is eating");
    }
}

final class Cat extends Animal{
    public void meow(){
        System.out.println("meow!");
    }
}

final class Dog extends Animal{
    public void bark(){
        System.out.println("woof!");
    }
}

final class Bird extends Animal{
    public void fly(){
        System.out.println(" am flying!");
    }

}

