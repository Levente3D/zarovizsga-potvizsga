package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    private String address;
    private int area;
    private int level;

    public Office(String address, int area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getLevel() {
        return level;
    }

    public int clean() {
        return area * 100 * level;
    }
}
