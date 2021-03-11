package CoreJava;

import java.util.EnumMap;

public class EnumMaps {
    enum Color {
        RED, BLUE, GREEN, YELLOW, ORANGE
    }

    public static void main(String[] args) {
        EnumMap<Color, Integer> color1 = new EnumMap<Color, Integer>(Color.class);
        color1.put(Color.RED, 1);
        color1.put(Color.BLUE, 2);
        color1.put(Color.GREEN, 3);
        color1.put(Color.YELLOW, 4);
        System.out.println("color 1 are : " + color1);
        EnumMap<Color, Integer> color2 = new EnumMap<Color, Integer>(Color.class);
        color2.putAll(color1);
        color2.put(Color.ORANGE, 5);
        System.out.println("color 2 are : " + color2);
    }
}
