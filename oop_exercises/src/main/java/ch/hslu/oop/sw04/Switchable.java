package ch.hslu.oop.sw04;

/**
 * The {@code Switchable} interface represents an object that can be switched on and off.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public interface Switchable {
    /**
     * Switches the object on.
     */
    void switchOn();

    /**
     * Switches the object off.
     */
    void switchOff();

    /**
     * Checks if the object is switched on.
     *
     * @return {@code true} if the object is switched on, {@code false} if not.
     */
    boolean isSwitchedOn();

    /**
     * Checks if the object is switched off.
     *
     * @return {@code true} if the object is switched off, {@code false} if not.
     */
    boolean isSwitchedOff();
}
