package DesignPatterns;

import DesignPatterns.BuilderDesignPattern.Phone;

public class MainBuilder {
    public static void main(String[] args) {
        Phone.Builder builder = new Phone.Builder()
                .setCamera("12 mp")
                .setPanel("black")
                .setProcessor("snapdragon");

        Phone phone = builder.build();

        System.out.println(phone);
    }
}
