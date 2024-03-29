package exercise;

public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    public int compareTo(Home another) {
        if (another.getArea() > area) {
            return -1;
        } else if (another.getArea() < area) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
