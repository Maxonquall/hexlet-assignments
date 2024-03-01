package exercise;

public class Segment {

    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Point getBeginPoint() {
        return point1;
    }

    public Point getEndPoint() {
        return point2;
    }

    public Point getMidPoint() {
        var x1 = point1.getX();
        var y1 = point1.getY();
        var x2 = point2.getX();
        var y2 = point2.getY();
        var x = (x2 + x1) / 2;
        var y = (y2 + y1) / 2;
        return new Point(x, y);
    }

}
