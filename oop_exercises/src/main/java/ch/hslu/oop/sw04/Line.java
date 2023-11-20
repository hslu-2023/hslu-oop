package ch.hslu.oop.sw04;

/**
 * The {@code Line} class represents a line in a two-dimensional coordinate system.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Line {

    private Point startPoint;
    private Point endPoint;

    /**
     * Creates a line object with the specified point objects.
     *
     * @param startPoint a point object
     * @param endPoint another point object
     */
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    /**
     * Gets the start point
     * @return the start point object
     */
    public Point getStartPoint() {
        return startPoint;
    }

    public Point getNewStartPoint(){
        Point newStartPoint = new Point(startPoint.getXCoordinate(), startPoint.getYCoordinate());
        return newStartPoint;
    }

    /**
     * Sets a new start point
     * @param startPoint the new start point object
     */
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Gets the end point object
     * @return the end point object
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * Sets a new end point
     * @param endPoint the new end point object
     */
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
