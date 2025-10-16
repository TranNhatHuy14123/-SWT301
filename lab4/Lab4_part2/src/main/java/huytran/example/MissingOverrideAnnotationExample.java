package huytran.example;

import java.util.logging.Logger;

class Animal {
    private static final Logger LOGGER = Logger.getLogger(Animal.class.getName());

    void speak() {
        LOGGER.info("Animal speaks");
    }
}

class Dog extends Animal {
    private static final Logger LOGGER = Logger.getLogger(Dog.class.getName());

    @Override
    void speak() {
        LOGGER.info("Dog barks");
    }
}

public class MissingOverrideAnnotationExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.speak();
        dog.speak();
    }
}
