package ch.hslu.oop.sw06.point;

/**
 * The {@code Point} class represents a point in a two-dimensional coordinate system.
 *
 * @author Raquel Lima
 * @version 2.0
 */
public class Point {

    private int xCoordinate;
    private int yCoordinate;

    /**
     * Creates a point object with the specified x and y-coordinates.
     *
     * @param xCoordinate the x-coordinate value.
     * @param yCoordinate the y-coordinate value.
     */
    public Point(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Point(final Point point){
        this.xCoordinate = point.xCoordinate;
        this.yCoordinate = point.yCoordinate;
    }

    /**
     * Returns the quadrant number in which the created point object is located.
     *
     * @return the number of the quadrant in which the point object is located.
     */
    public int findQuadrant() {
        if (xCoordinate == 0 || yCoordinate == 0) {
            return 0;
        } else if (xCoordinate > 0) {
            return (yCoordinate > 0) ? 1 : 4;
        } else {
            return (yCoordinate > 0) ? 2 : 3;
        }
    }

    public void moveRelative(final int x, final int y) {
        this.xCoordinate += x;
        this.yCoordinate += y;
    }

    public void moveRelative(final Point vector) {
        this.xCoordinate += vector.getXCoordinate();
        this.yCoordinate += vector.getYCoordinate();
    }

    public void moveRelative(final float angleInDegrees, final float magnitude) {
        float angleInRadians = (float) Math.toRadians(angleInDegrees);

        this.xCoordinate += (int) (magnitude * Math.cos(angleInRadians));
        this.yCoordinate += (int) (magnitude * Math.sin(angleInRadians));
    }

    /**
     * Gets the x-coordinate value
     *
     * @return the x-coordinate int value
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the new x-coordinate value
     *
     * @param xCoordinate the new x-coordinate int value
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Gets the y-coordinate value
     *
     * @return the y-coordinate int value
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the new y-coordinate value
     *
     * @param yCoordinate the new y-coordinate int value
     */
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}

