package MyClass;

import MyInterface.Age;

import java.util.Random;

public class CamelAge implements Age {
    public int age;

    @Override
    public int getAge() {
        int min = 2;
        int max = 50;
        age = new Random().nextInt((max - min) + 1) + min;
        return age;
    }
}
