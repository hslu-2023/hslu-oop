package ch.hslu.oop.exam;

import java.time.Instant;

public interface QuittungInterface {

    void addPosition(Position position);

    int getTotalPositionNumber();

    float getTotalPositionPrice();

    Instant getTimestamp();

}
