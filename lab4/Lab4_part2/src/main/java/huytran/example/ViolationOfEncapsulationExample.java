package huytran.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ViolationOfEncapsulationExample {
    private static final Logger LOGGER = Logger.getLogger(ViolationOfEncapsulationExample.class.getName());
    private String name;
    private int age;
    public ViolationOfEncapsulationExample(String name, int age) {
        setName(name);
        setAge(age);
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            LOGGER.warning("Invalid name provided.");
        } else {
            this.name = name;
        }
    }
    public void setAge(int age) {
        if (age <= 0) {
            LOGGER.warning("Invalid age. Must be positive.");
        } else {
            this.age = age;
        }
    }
    public void display() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(() -> String.format("Name: %s, Age: %d", name, age));
        }
    }

    public static void main(String[] args) {
        ViolationOfEncapsulationExample user = new ViolationOfEncapsulationExample("Huy", 22);
        user.display();
        user.setName("Minh");
        user.setAge(25);
        user.display();
    }
}
