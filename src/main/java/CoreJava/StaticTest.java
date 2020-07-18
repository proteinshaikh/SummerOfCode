package CoreJava;

public class StaticTest {

    public static void main(String[] args) {
        StaticTest st=new StaticTest();
        //st.doStaticTest();
        st.doThisWork();
    }

     public void doStaticTest(){
        double var=Math.sqrt(2);
        System.out.println(var);
    }

    public void doThisWork( ){
        String str= "Zee";
        String str1="Shaikh";
        System.out.println("Wrapper String : "+str);
        System.out.println("primitive string : "+str1);

    }
}
