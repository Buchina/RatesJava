package MyClass;


import MyInterface.AnimalFactory;


public class Participant {
    private final AnimalFactory factory;
    private final int speed;
    private final int age;
    private final String name;

    public Participant(AnimalFactory factory) {
        this.factory = factory;
        age = factory.createAge();
        speed = factory.createSpeed();
        name = factory.createName();

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("\nБЕГУН: " + name + "\nВОЗРАСТ: " + age + " лет\nСКОРОСТЬ: " + speed+" км/ч\n");
        return out.toString();
    }


}
