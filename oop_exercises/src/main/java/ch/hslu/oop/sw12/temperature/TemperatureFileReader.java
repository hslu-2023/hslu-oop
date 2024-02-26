package ch.hslu.oop.sw12.temperature;

import java.io.File;

public class TemperatureFileReader {
    public static void main(String[] args) {
        String filePath = "src/main/resources/netatmo-export-202301-202304.csv";

        if (new File(filePath).exists()) {
            TemperatureProgression list = new TemperatureProgression();
            list.loadListFromFile(filePath);
            System.out.println("Max temperature: " + list.getMaxMeasurement());
            System.out.println("Max temperature: " + list.getMinMeasurement());
            System.out.println("Average temperature: " + list.getTemperatureAverage());

        } else {
            System.out.println("The entered file at" + filePath + "does not exist!");
        }
    }
}
