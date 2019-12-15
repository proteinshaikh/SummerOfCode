import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayToArrayList {
    public static void main(String a[]) {
        ArrayToArrayList aa = new ArrayToArrayList();
        //aa.vectors();
        //aa.arrayToList();
        //aa.whileloop();
        aa.dowhileloop();
    }

    public void arrayToList() {
        String[] str = {"Zeeshan", "Shaikh", "Akram"};

        List<String> list = new ArrayList<String>();

        for (String name : str) {
            list.add(name);

        }
        System.out.println(list);
    }

    public void vectors() {
        Vector<String> v = new Vector();

        v.add("zee");
        v.add("shaikh");
        for (String str : v) {
            System.out.println(str);
        }
        Vector<Integer> vint = new Vector();
        int i = 0;
        for (; i < 10; ) {
            vint.add(i);
            i++;
        }
        for (int b : vint) {
            System.out.println(b);
        }

    }

    public void whileloop() {
        Vector<Integer> wint = new Vector();
        int j = 0;
        while (j < 10) {
            wint.add(j);
            j++;
        }
        for (int c : wint) {
            System.out.println("while loop" + c);
        }
    }

    public void dowhileloop(){
        Vector<Integer> dint = new Vector();
        int k = 0;
        do{
            dint.add(k);
            k++;
        }while (k<10);

        for(int d : dint){
            System.out.println(d);
        }
    }
}
