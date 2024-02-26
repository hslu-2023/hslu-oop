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
     * @param endPoint   another point object
     */
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = new Point(startPoint.getXCoordinate(), startPoint.getYCoordinate());
        this.endPoint = new Point(endPoint.getXCoordinate(), endPoint.getYCoordinate());
    }

    public Point getStartPoint() {
        return new Point(startPoint.getXCoordinate(), startPoint.getYCoordinate());
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint.getXCoordinate(), startPoint.getYCoordinate());
    }

    public Point getEndPoint() {
        return new Point(endPoint.getXCoordinate(), endPoint.getYCoordinate());
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = new Point(endPoint.getXCoordinate(), endPoint.getYCoordinate());
    }
}
