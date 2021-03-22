package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public int clean() {
        return area * 80;
    }
}
