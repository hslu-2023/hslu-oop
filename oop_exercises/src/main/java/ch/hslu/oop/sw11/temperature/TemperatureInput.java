package ch.hslu.oop.sw11.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

/**
 * The {@code Main} class represents the entry point of the temperature input program.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class TemperatureInput implements TemperatureChangeListener {

    private final TemperatureProgression list = new TemperatureProgression();

    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureInput.class);

    private TemperatureInput() {
        this.list.addPropertyChangeListener(this);
        this.addTemperatureToProgression();
    }

    /**
     * Executes the temperature input program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        new TemperatureInput();
    }

    private void addTemperatureToProgression() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please enter a temperature in Celsius (or 'exit' to exit):");
            String input = scanner.next();

            if ("exit".equals(input)) {
                System.out.println("Program is terminated.");
                if (list.getCount() > 0) {
                    this.writeTotFile();
                    this.readFromFile();
                }
                break;
            }

            try {
                float value = Float.parseFloat(input);
                Temperature temperature = Temperature.createFromCelsius(value);
                Measurement measurement = new Measurement(temperature);
                System.out.println("Temperature: " + input + "C");
                list.add(measurement);

            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException caught! Please enter a valid temperature value in Celsius.", e);
                System.out.println("Please enter a valid temperature value in Celsius.");
            } catch (IllegalArgumentException e) {
                LOG.error("IllegalArgumentException caught! Please enter a valid temperature value in Celsius. Temperature should be greater than or equal to -273.15 C.");
            }

        } while (true);
    }

    private void writeTotFile() {
        try (FileOutputStream fos = new FileOutputStream("./demo.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeInt(list.getCount());

            for (Measurement m : list.getMeasurementList()) {
                dos.writeFloat(m.getTemperature().getCelsius());
            }

            System.out.println("Temperature list successfully written to file: " + "./demo.txt");

        } catch (IOException e) {
            LOG.error("Error writing to file: {}", e.getMessage(), e);
        }
    }

    private void readFromFile() {
        try (FileInputStream fis = new FileInputStream("./demo.txt");
             DataInputStream dis = new DataInputStream(fis)) {

            System.out.println("Reading " + dis.readInt() + " temperatures from file:");

            int count = 0;
            for (Measurement m : list.getMeasurementList()) {
                count++;
                System.out.println("Temperature " + count + ": " + dis.readFloat() + "C");
            }

        } catch (IOException ioe) {
            LOG.error("Error reading from file: {}", ioe.getMessage(), ioe);
        }
    }

    @Override
    public void temperatureChange(final TemperatureEvent evt) {
        if (evt.getExtrema() == TemperatureProgression.TemperaturExtrema.MIN) {
            System.out.println("The min value has changed from " + evt.getOldValue() + "C to " + evt.getNewValue() + "C");
        }
        if (evt.getExtrema() == TemperatureProgression.TemperaturExtrema.MAX) {
            System.out.println("The max value has changed from " + evt.getOldValue() + "C to " + evt.getNewValue() + "C");
        }
    }
}