package exercise;

public class App {
    public static void printSquare(Circle circle) {
        try {
            double squareDouble = circle.getSquare();
            int squareInt = (int) Math.round(squareDouble);
            System.out.println(squareInt);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
