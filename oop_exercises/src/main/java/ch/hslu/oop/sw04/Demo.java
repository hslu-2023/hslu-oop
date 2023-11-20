package ch.hslu.oop.sw04;

/**
 * The {@code Demo} class implements methods from the exercises.
 *
 * @author Raquel Lima
 * @version 3.0
 */
public class Demo {

    /**
     * Returns the greater of two int values. If the arguments have the same value, the result is that same value.
     *
     * @param a an int value
     * @param b another int value
     * @return the largest of a and b
     */
    public int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }

    }

    /**
     * Returns the smaller of two int values. If the arguments have the same value, the result is that same value.
     *
     * @param a an int value
     * @param b another int value
     * @return the smallest of a and b
     */
    public int min(int a, int b) {
        if (a >= b) {
            return b;
        } else {
            return a;
        }
    }

    /**
     * Returns the greatest of three int values. If the arguments have the same value, the result is that same value.
     *
     * @param a an int value
     * @param b another int value
     * @param c a third int value
     * @return the largest of a, b and c
     */
    public int max1(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        } else {
            return c;
        }
    }

    /**
     * Returns the greatest of three int values making use of {@code max()}. If the arguments have the same value, the result is that same value.
     *
     * @param a an int value
     * @param b another int value
     * @param c a third int value
     * @return the largest of a, b and c
     */
    public int max2(int a, int b, int c) {
        if (a >= b) {
            return max(a, c);
        } else {
            return max(b, c);
        }
    }

    /**
     * Prints numbers from 0 to 10 using a for loop.
     */
    public void forCounter() {
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }
    }

    /**
     * Prints numbers from 0 to 10 using a while loop.
     */
    public void whileCounter() {
        int counter = 0;
        while (counter < 11) {
            System.out.println(counter);
            counter++;
        }
    }

    /**
     * Adds a small increment to a floating-point number until it reaches or exceeds 1.0 using a while loop, printing the result and the count of increments.
     */
    public void addUntilOneWhile() {
        int counter = 0;
        float number = 0.9f;
        while (number < 1.0f) {
            number += 0.000025f;
            counter++;
            System.out.println(number);
            System.out.println(counter);
        }
    }

    /**
     * Adds a small increment to a floating-point number in a for loop until it reaches or exceeds 1.0, printing the loop index and the result.
     */
    public void addUntilOneFor() {
        float number = 0.9f;
        for (int i = 0; i <= 4000; i++) {
            number += 0.000025f;
            System.out.println(i);
            System.out.println(number);
        }
    }

    /**
     * Prints a box made of '#' characters with the specified width and height.
     *
     * @param width  The width of the box.
     * @param height The height of the box.
     */
    public void printBox(final int width, final int height) {

        for (int i = 0; i < width; i++) {
            System.out.print("#");
        }
        System.out.printf("%n");
        for (int i = 0; i < height - 2; i++) {
            System.out.print("#");
            for (int j = 0; j < width - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("#");
            System.out.printf("%n");
        }
        for (int i = 0; i < width; i++) {
            System.out.print("#");
        }
    }

}
