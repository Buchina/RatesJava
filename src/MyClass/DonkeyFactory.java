package MyClass;

import MyInterface.AnimalFactory;

public class DonkeyFactory implements AnimalFactory {
    @Override
    public String createName() {
        return "Осёл";
    }

    @Override
    public int createAge() {
        return new DonkeyAge().getAge();
    }

    @Override
    public int createSpeed() {
        return new DonkeySpeed().getSpeed();
    }
}
