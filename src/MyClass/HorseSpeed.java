package MyClass;

import MyInterface.Speed;

import java.util.Random;

public class HorseSpeed implements Speed {
    public int speed;

    @Override
    public int getSpeed() {
        int min = 35;
        int max = 60;
        speed = new Random().nextInt((max - min) + 1) + min;
        return speed;

    }
}
