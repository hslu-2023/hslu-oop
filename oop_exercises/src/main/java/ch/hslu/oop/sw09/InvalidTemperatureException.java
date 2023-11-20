package ch.hslu.oop.sw09;

/**
 * The {@code InvalidTemperatureException} class represents an exception related to invalid temperature values.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class InvalidTemperatureException extends Exception {
    /**
     * Constructs an InvalidTemperatureException with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidTemperatureException(String message) {
        super(message);
    }
}