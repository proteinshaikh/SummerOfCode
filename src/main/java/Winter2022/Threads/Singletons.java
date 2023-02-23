package Winter2022.Threads;

public class Singletons {

    private static Singletons instance;

    private Singletons(){

    }

    public Singletons getInstance(){
        if(instance==null){
            return new Singletons();
        }else{
            return instance;
        }
    }

    public static void main(String[] args) {

    }
}
