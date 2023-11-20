package ch.hslu.oop.sw08.temperature;

public interface TemperatureProgressionInterface {

    void add(final Temperature t);

    void clear();

    int getCount();

    float getMax();

    float getMin();

    float getAverage();

}
