package Winter2022.multipleinheritance;

public interface Mother {

    String son();


    default String stepson(){
        return "I am Stepson from Mother";
    }

}
