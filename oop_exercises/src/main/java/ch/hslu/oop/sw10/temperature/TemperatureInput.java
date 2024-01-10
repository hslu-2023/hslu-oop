package ch.hslu.oop.sw10.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * The {@code Main} class represents the entry point of the temperature input program.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class TemperatureInput implements TemperatureChangeListener {

    TemperatureProgression list = new TemperatureProgression();

    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureInput.class);

    /**
     * Executes the temperature input program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        new TemperatureInput();
    }

    public TemperatureInput() {
        this.list.addPropertyChangeListener(this);
        this.addTemperatureToProgression();
    }

    public void addTemperatureToProgression() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please enter a temperature in Celsius (or 'exit' to exit):");
            String input = scanner.next();

            if ("exit".equals(input)) {
                System.out.println("Program is terminated.");
                System.out.println(list);
                break;
            }

            try {
                float value = Float.parseFloat(input);
                Temperature temperature = Temperature.createFromCelsius(value);
                System.out.println("Temperature: " + input + "°C");
                list.add(temperature);

            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException caught! Please enter a valid temperature value in Celsius.", e);
                System.out.println("Please enter a valid temperature value in Celsius.");
            } catch (IllegalArgumentException e) {
                LOG.error("IllegalArgumentException caught! Please enter a valid temperature value in Celsius. Temperature should be greater than or equal to -273.15 °C.");
            }

        } while (true);
    }

    @Override
    public void temperatureChange(TemperatureEvent evt) {
        if (evt.getExtrema() == TemperatureProgression.TemperaturExtrema.MIN) {
            System.out.println("The min value has changed from " + evt.getOldValue() + "°C to " + evt.getNewValue() + "°C");
        }
        if (evt.getExtrema() == TemperatureProgression.TemperaturExtrema.MAX) {
            System.out.println("The max value has changed from " + evt.getOldValue() + "°C to " + evt.getNewValue() + "°C");
        }
    }
}