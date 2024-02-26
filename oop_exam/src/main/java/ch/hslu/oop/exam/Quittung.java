package ch.hslu.oop.exam;

import java.time.Instant;
import java.util.HashSet;

public class Quittung implements QuittungInterface {

    private final Instant timestamp;

    /**
     * We would have to implement the equals() and hashCode() methods to not have any duplicates.
     */
    private final HashSet<Position> positionen = new HashSet<Position>();

    public Quittung() {
        this.timestamp = Instant.now();
    }

    /**
     * This method adds a Position that contains an article and an amount to a list of Positions, which represents a purchase.
     *
     * @param position a Position object with contain an article and an amount. The input of an amount of articles is optional, the default amount set is 1.
     */
    @Override
    public void addPosition(Position position) {
        this.positionen.add(position);
    }

    @Override
    public int getTotalPositionNumber() {
        return this.positionen.size();
    }

    @Override
    public float getTotalPositionPrice() {
        if (this.positionen.isEmpty()) {
            return Float.NaN;
        }

        float sum = 0;

        for (Position p : this.positionen) {
            sum += p.getArtikel().getPreis() * p.getMenge();
        }

        return sum;
    }

    @Override
    public Instant getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Quittung[" +
                "timestamp=" + this.timestamp +
                ']';
    }
}
