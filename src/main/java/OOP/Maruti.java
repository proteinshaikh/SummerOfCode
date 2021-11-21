package OOP;

public class Maruti implements Cars {


    @Override
    public String engine(String engineName) {
        return engineName;
    }


    public String engine(String engineName, int num) {
        return engineName + " : " + num;
    }

    @Override
    public String body(String type) {
        return "Suv";
    }
}
