package ch.hslu.oop.sw03;

public class Demo {

    public int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }

    }

    public int min(int a, int b) {
        if (a >= b) {
            return b;
        } else {
            return a;
        }
    }

    public int max1(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        } else {
            return c;
        }
    }

    public int max2(int a, int b, int c) {
        if (a >= b) {
            return max(a, c);
        } else {
            return max(b, c);
        }
    }

    public void forCounter() {
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }
    }

    public void whileCounter() {
        int counter = 0;
        while (counter < 11) {
            System.out.println(counter);
            counter++;
        }
    }

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

    public void addUntilOneFor() {
        float number = 0.9f;
        for (int i = 0; i <= 4000; i++) {
            number += 0.000025f;
            System.out.println(i);
            System.out.println(number);
        }
    }

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
