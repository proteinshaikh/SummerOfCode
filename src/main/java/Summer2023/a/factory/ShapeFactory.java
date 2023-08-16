package Summer2023.a.factory;

public class ShapeFactory {

    public Shape createShape(String type){
        return switch (type.toLowerCase()) {
            case "square" -> new Square();
            case "rectangle" -> new Rectangle();
            default -> throw new IllegalArgumentException("shape not found!");
        };
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape square = factory.createShape("square");
        Shape rectangle = factory.createShape("rectangle");

        square.draw();
        rectangle.draw();
    }
}
