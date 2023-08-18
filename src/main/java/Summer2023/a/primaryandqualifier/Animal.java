package Summer2023.a.primaryandqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface Animal {
    String makeSound();
}

@Component
@Primary
 class Dog implements Animal {
    public String makeSound() {
        return "Woof!";
    }
}

@Component
class Cat implements Animal {
    public String makeSound() {
        return "Meow!";
    }
}

@Component
class PetOwner {
    @Autowired
    private Animal animal;


    public PetOwner(@Qualifier("cat") Animal animal) {
        this.animal = animal;
    }
}

