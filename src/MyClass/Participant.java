package MyClass;


import MyInterface.AnimalFactory;


public class Participant {
    private final AnimalFactory factory;
    public final int speed;
    public final int age;
    public final int power;
    public final String name;

    public Participant(AnimalFactory factory) {
        this.factory = factory;
        power = factory.createPower();
        age = factory.createAge();
        speed = factory.createSpeed();
        name = factory.createName();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("\nБЕГУН: " + name + "\nВОЗРАСТ: " + age + " лет\nСКОРОСТЬ: " + speed + " км/ч\nСИЛА: " + power + " из 10");
        return out.toString();
    }
}
