package Java_8;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Different {
    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, CloneNotSupportedException, IOException, ClassNotFoundException {

        //type 1
        Different different1=new Different();
        different1.hello();

        //type 2
        Different different2= Different.class.newInstance();
        different2.hello();

        //type 3
        Constructor<Different> constructor=Different.class.getConstructor();
        Different different3 = constructor.newInstance();

        //type 4
        Different different4=(Different) different3.clone();

        //type 5 using Deserialization
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("data.obj"));
        Different different5=(Different) in.readObject();



    }

    public void hello(){
        System.out.println("hello there!");
    }
}
