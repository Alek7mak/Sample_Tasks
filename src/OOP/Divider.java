package OOP;

public class Divider extends WritingMaterials {

    private boolean draw = true;
    private String dividerType;
    private boolean metal;

    public void drawCircle() {
        System.out.println("Drawing circle");
    }

    public String getDividerType() {
        return dividerType;
    }

    public boolean isMetal() {
        return metal;
    }

    public void setDividerType(String dividerType) {
        this.dividerType = dividerType;
    }

    public void setMetal(boolean metal) {
        this.metal = metal;
    }

    @Override
    public void display() {
        System.out.println("This is Divider" +
                "Name: " + getName() +
                ", Color: " + getColor() +
                ", Length: " + getLength() +
                ", Price: " + getPrice() +
                ", Can draw: Yes" +
                ", Divider type: " + getDividerType() +
                ", Metal: " + (isMetal() ? "Yes" : "No"));
    }
}