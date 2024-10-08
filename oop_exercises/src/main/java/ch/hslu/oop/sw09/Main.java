package ch.hslu.oop.sw09;

import java.util.Scanner;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * The {@code Main} class represents the entry point of the temperature input program.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Main {
    private static final Logger LOG =
            LoggerFactory.getLogger(Main.class);

    /**
     * Executes the temperature input program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            LOG.debug("exceptionCatch: Begin");
            System.out.println("Please enter temperature (or 'exit' to exit):");
            input = scanner.next();

            if ("exit".equals(input)) {
                System.out.println("Program is terminated.");
                LOG.debug("exceptionCatch: End");
                break;
            }

            try {
                LOG.debug("try-Block: Begin");
                float value = Float.parseFloat(input);
                System.out.println("Temperature: " + value + "C");
                LOG.info("Temperature: {}C", input);
                LOG.debug("try-Block: End");

            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException caught! Please enter a valid temperature value.", e);
                System.out.println("Please enter a valid temperature value.");
            } catch (IllegalArgumentException e) {
                LOG.error("IllegalArgumentException caught! Please enter a valid temperature value. Temperature should be greater than or equal to -273.15 Celsius.");
            }

        } while (true);
    }
}