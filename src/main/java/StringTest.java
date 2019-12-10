public class StringTest {


    public static void main(String[] args) {
        String a1 = "hello";
        String a2 = "world";
        a1 = a1.concat(a2);
        System.out.println(a1);

        String str = new String("Zeeshan ");
        String tst = str.concat("test");
        String fst = str.trim();
        System.out.println(tst);
        System.out.println(fst);
        int i=8;
        for(++i;i<10;i++){
            i=i+1;
        }
        System.out.println(i);


    }
}


