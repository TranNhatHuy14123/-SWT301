package huytran.example;

import java.util.logging.Logger;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    private static final Logger LOGGER = Logger.getLogger(Circle.class.getName());

    @Override
    public void draw() {
        LOGGER.info("Drawing a circle");
    }
}

public class UnimplementedInterfaceExample {
    public static void main(String[] args) {
        Drawable circle = new Circle();
        circle.draw();
    }
}
