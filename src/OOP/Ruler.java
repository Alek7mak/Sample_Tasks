package OOP;

public class Ruler extends WritingMaterials {

    private boolean draw = false;
    private double length;
    private boolean wood;

    public void measure() {
        System.out.println("Check length");
    }

    public boolean isWood() {
        return wood;
    }


    public void setLength(int length) {
        this.length = length;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    @Override
    public void display() {
        System.out.println("This is Ruler" +
                "Name: " + getName() +
                ", Color: " + getColor() +
                ", Length: " + getLength() +
                ", Price: " + getPrice() +
                ", Can draw: False" +
                ", Wood: " + (isWood() ? "Yes" : "No"));
    }
}
