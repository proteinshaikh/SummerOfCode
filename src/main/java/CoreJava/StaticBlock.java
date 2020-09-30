package CoreJava;

public class StaticBlock {
    public static void main(String[] args) {
        Block block=new Block();
        Block block1=new Block();

    }
}

class Block{
    Block(){
        System.out.println("constructor called");
    }

    static{
        System.out.println("static block called");
    }
}
