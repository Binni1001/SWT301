package kietdt.example;

import java.util.logging.Logger;

interface IPrinter {
    void print(String message);
}

class ConsolePrinter implements IPrinter {
    private static final Logger logger = Logger.getLogger(ConsolePrinter.class.getName());

    public void print(String message) {
        logger.info(message);
    }
}

class Report {
    private IPrinter printer;

    public Report(IPrinter printer) {
        this.printer = printer;
    }

    void generate() {
        printer.print("Generating report...");
    }

    public static void main(String[] args) {
        IPrinter printer = new ConsolePrinter();
        Report report = new Report(printer);
        report.generate();
    }
}
