package ch.hslu.oop.sw11.temperature;

import java.util.ArrayList;

public interface TemperatureProgressionInterface {

    void add(final Measurement m);

    void clear();

    int getCount();

    Measurement getMaxMeasurement();

    Measurement getMinMeasurement();

    Temperature getTemperatureAverage();

    ArrayList<Measurement> getMeasurementList();

}
