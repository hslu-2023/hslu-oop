package ch.hslu.oop.sw02;

final public class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        Temperature temp1 = new Temperature();
        System.out.println(temp1.convertCelsiusToKelvin());
        System.out.println(temp1.convertCelsiusToFahrenheit());

    }
}