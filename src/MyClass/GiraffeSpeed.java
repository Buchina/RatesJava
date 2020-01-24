package MyClass;

import MyInterface.Speed;

import java.util.Random;

public class GiraffeSpeed implements Speed {
    public int speed;

    @Override
    public int getSpeed() {
        int min = 20;
        int max = 55;
        speed = new Random().nextInt((max - min) + 1) + min;
        return speed;
    }
}
