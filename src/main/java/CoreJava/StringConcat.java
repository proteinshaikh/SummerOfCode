package CoreJava;

import java.util.Arrays;
import java.util.List;

public class StringConcat {
    public static void main(String[] args) {
        String[] s={"a","bc"};
        System.out.println(StringUtils.concat(s));

    }
}

class StringUtils{
    static String concat(String[] strings){
       StringBuffer sb=new StringBuffer();
       for(int i=0;i<strings.length;i++){
           sb.append(strings[i]);
       }
       return sb.toString();


    }
}
