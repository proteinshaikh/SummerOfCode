package CoreJava;

public class TestAdd {
    public static void main(String[] args) {
        System.out.println(AddThis.a(3,1));

    }
}

class AddThis{
    static boolean a(int i, int j){
        if(i==1 || j==1 || (i+j)==1){
            return true;
        }else{
            return false;
        }
    }
}
