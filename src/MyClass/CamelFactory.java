package MyClass;

import MyInterface.AnimalFactory;

public class CamelFactory implements AnimalFactory {
    @Override
    public String createName() {
        return "Верблюд";
    }

    @Override
    public int createAge() {
        return new CamelAge().getAge();
    }

    @Override
    public int createSpeed() {
        return new CamelSpeed().getSpeed();
    }

    @Override
    public int createPower() {
        return new CamelPower().getPower();
    }
}
