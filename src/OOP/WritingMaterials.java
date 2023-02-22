package OOP;

public class WritingMaterials {

    private String name;
    private String color;
    private int price;
    private double length;
    private boolean draw;

    // Constructors
    public WritingMaterials() {}

    public WritingMaterials(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public WritingMaterials(String name, int price) {
        this.name = name;
        color = "No Color";
        this.price = price;
    }

    public WritingMaterials(int price, double length, boolean draw) {
        name = "No Name";
        color = "No Color";
        this.price = price;
        this.length = length;
        this.draw = draw;
    }

    public WritingMaterials(String name, String color, int price, double length, boolean draw) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.length = length;
        this.draw = draw;
    }

    // Methods
    public void display() {
        System.out.println("Name: " + name +
                ", Color: " + color +
                ", Length: " + length +
                ", Price: " + price +
                ", Can draw: " + (draw ? "Yes" : "No"));
    }

    public void replaceRod(String color) {
        this.color = color;
    }

    public void priceUp(int plus) {
        price += plus;
    }

    public void priceDown(int minus) {
        price -= minus;
    }

    public void draw() {
        printMessage(1, this.color);
    }

    public void draw(int n) {
        printMessage(n, this.color);
    }

    public void draw(String color) {
        printMessage(1, color);
    }

    public void draw(String color, int n) {
        printMessage(n, color);
    }

    private void printMessage(int n, String color) {
        System.out.println(draw ? name + " провёл линий: " + n + ". Их цвет - " + color + "."
                : name + " не может ничего нарисовать.");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public double getLength() {
        return length;
    }

    public boolean isDraw() {
        return draw;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
