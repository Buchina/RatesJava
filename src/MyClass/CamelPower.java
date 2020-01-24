package MyClass;

import MyInterface.Power;

import java.util.Random;

public class CamelPower implements Power {
    public int power;

    @Override
    public int getPower() {
        int min = 1;
        int max = 10;
        power = new Random().nextInt((max - min) + 1) + min;
        return power;

    }
}
