package Summer2023.c;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Employees> list = new ArrayList<>();

        //max age
        list.stream()
                .mapToInt(Employees::getAge)
                .max();
    }
}

@Data
class Employees {

    private int id;

    private String name;
    private int age;
}

// predicate working sample
//real sql db connection
// observer example





