package OOP;

public class Pen extends WritingMaterials {

    private int countColor;
    private boolean auto;
    private boolean draw = true;

    public void writeMyName() {
        System.out.println("Aleksey");
    }

    public int getCountColor() {
        return countColor;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setCountColor(int countColor) {
        this.countColor = countColor;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    @Override
    public void display() {
        System.out.println("This is Pen" +
                "Name: " + getName() +
                ", Color: " + getColor() +
                ", Length: " + getLength() +
                ", Price: " + getPrice() +
                ", Can draw: Yes" +
                ", Count colors: " + getCountColor() +
                ", Auto: " + (isAuto() ? "Yes" : "No"));
    }
}
