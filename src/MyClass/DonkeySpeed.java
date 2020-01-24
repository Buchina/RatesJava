package MyClass;

import MyInterface.Speed;

import java.util.Random;

public class DonkeySpeed implements Speed {
    public int speed;

    @Override
    public int getSpeed() {
        int min = 1;
        int max = 70;
        speed = new Random().nextInt((max - min) + 1) + min;
        return speed;
    }
}
