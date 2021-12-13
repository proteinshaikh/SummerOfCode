package CoreJava;

import java.util.ArrayList;

public class Arraylist
{
    public static void main(String args[])
    {
        ArrayList obj = new ArrayList();
        obj.add("A");
        obj.add("B");
        obj.add("C");
        obj.add(1, "D");
        System.out.println(obj);
    }
}
