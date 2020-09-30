package CoreJava;

public class InitializerBlock {
    public static void main(String[] args) {
        Blocks blocks=new Blocks();
        Blocks blocks1=new Blocks("hi");
    }
}

class Blocks{
    {
        System.out.println("Initializer block is called");
    }
    {
        System.out.println("Initializer block2 is called");
    }
    Blocks(){
        System.out.println("default constructor is called");
    }


    Blocks(String string){
        System.out.println("parameterized constructor is called");
    }
}
