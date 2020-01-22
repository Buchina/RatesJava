package MyClass;

import MyInterface.AnimalFactory;

public class HorseFactory implements AnimalFactory {

    @Override
    public String createName() {
        return "Лошадь";
    }
    @Override
    public int createAge() {
        return new HorseAge().getAge();
    }

    @Override
    public int createSpeed() {
        return new HorseSpeed().getSpeed();
    }
}
