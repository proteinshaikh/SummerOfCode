package CoreJava;

public class ParentChildSuperInMethod {
    public static void main(String[] args) {
        Childs c = new Childs();

    }
}

class Parents{
    int var = 100;
    Parents(){
        System.out.println("Parentvar = "+var);
    }

}

class Childs extends Parents{
    int var = 50;
    Childs(){

        System.out.println("Child var =  : "+super.var);
    }
}