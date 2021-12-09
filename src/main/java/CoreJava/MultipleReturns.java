package CoreJava;

public class MultipleReturns {
    public static void main(String[] args) {
        System.out.println(oneLessThanTwo());
        System.out.println(oneLessThanZero());

    }

    static boolean  oneLessThanTwo(){
        if( 1 < 2 ){
            return true;
        }
        return false;
    }

    static boolean  oneLessThanZero(){
        if( 1 < 0 ){
            return true;
        }
        return false;
    }

    static String  getZee(){
       return "Zee";
    }
}
