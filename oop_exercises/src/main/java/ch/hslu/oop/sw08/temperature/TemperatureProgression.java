package ch.hslu.oop.sw08.temperature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TemperatureProgression implements TemperatureProgressionInterface {

    private final Collection<Temperature> temperatureList;

    public TemperatureProgression() {
        this.temperatureList = new ArrayList<>();
    }

    @Override
    public void add(final Temperature t) {
        this.temperatureList.add(t);
    }

    @Override
    public void clear() {
        this.temperatureList.clear();
    }

    @Override
    public int getCount() {
        return this.temperatureList.size();
    }

    @Override
    public float getMax() {
        if (temperatureList.isEmpty()) {
            return 0;
        }
        return Collections.max(this.temperatureList).getCelsius();
    }

    @Override
    public float getMin() {
        if (temperatureList.isEmpty()) {
            return 0;
        }
        return Collections.min(this.temperatureList).getCelsius();
    }

    @Override
    public float getAverage() {
        if (temperatureList.isEmpty()) {
            return 0;
        }

        float sum = 0;

        for (Temperature t : temperatureList) {
            sum += t.getCelsius();
        }

        return sum / temperatureList.size();
    }

}
