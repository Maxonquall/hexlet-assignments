package exercise;

public class Flat implements Home {
    private double area;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area + balconyArea;
        this.floor = floor;
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
        return "Квартира площадью " + area + " метров на " + floor + " этаже";
    }
}

