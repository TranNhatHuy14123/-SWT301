package huytran.example;

import java.io.*;
import java.util.logging.Logger;

public class PathTraversalExample {
    private static final Logger LOGGER = Logger.getLogger(PathTraversalExample.class.getName());

    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt";
        File file = new File(userInput);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            LOGGER.info("Reading file: " + file.getPath());
            reader.close();
        }
    }
}
