package ch.hslu.oop.sw10.temperature;

public interface TemperatureProgressionInterface {

    void add(final Temperature t);

    void clear();

    int getCount();

    Temperature getMax();

    Temperature getMin();

    Temperature getAverage();

    String getList();

}
