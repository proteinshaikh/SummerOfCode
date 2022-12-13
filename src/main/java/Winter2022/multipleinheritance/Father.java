package Winter2022.multipleinheritance;

public interface Father {

    String son();

    default String stepson(){
        return "I am Stepson from father";
    }
}
