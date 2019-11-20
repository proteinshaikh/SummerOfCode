import java.util.ArrayList;
import java.util.List;

public class ArrayToArrayList {
    public static void main(String a[]){

        String[] str = {"Zeeshan", "Shaikh", "Akram"};

        List<String> list = new ArrayList<String>();

        for(String name: str){
            list.add(name);

        }
        System.out.println(list);

    }
}
