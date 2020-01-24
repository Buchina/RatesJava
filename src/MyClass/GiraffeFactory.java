package MyClass;

import MyInterface.AnimalFactory;

public class GiraffeFactory implements AnimalFactory {
    @Override
    public String createName() {
        return "Жираф";
    }

    @Override
    public int createAge() {
        return new GiraffeAge().getAge();
    }

    @Override
    public int createSpeed() {
        return new GiraffeSpeed().getSpeed();
    }

    @Override
    public int createPower() {
        return new GiraffePower().getPower();
    }
}
