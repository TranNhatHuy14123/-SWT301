package huytran.example;

import java.util.logging.Logger;

class Printer {
    private static final Logger logger = Logger.getLogger(Printer.class.getName());

    void print(String message) {
        logger.info(message);
    }
}

class Report {
    private final Printer printer = new Printer();

    void generate() {
        printer.print("Generating report...");
        printer.print("Processing data...");
        printer.print("Saving report to database...");
        printer.print("Report generation completed successfully!");
    }

    public static void main(String[] args) {
        new Report().generate();
    }
}
