package MyClass;

import MyInterface.Age;

import java.util.Random;

public class HorseAge implements Age {
    public int age;

    @Override
    public int getAge() {
        int min = 2;
        int max = 25;
        //Random r = new Random();
        age = new Random().nextInt((max - min) + 1) + min;
        return age;
    }
}
