package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }
    int cleanAll() {
        int price = 0;
        Iterator<Cleanable> it = cleanables.iterator();
        while(it.hasNext()) {
            Cleanable next = it.next();
            price = price + next.clean();
            it.remove();
        }
        return price;
    }
    int cleanOnlyOffices() {
        int price = 0;
        Iterator<Cleanable> it = cleanables.iterator();
        while(it.hasNext()) {
            Cleanable next = it.next();
            if (next instanceof Office) {
                price = price + next.clean();
                it.remove();
            }
        }
        return price;
    }
    List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> addressMatch = new ArrayList<>();
        for (Cleanable cleanable: cleanables) {
            if (cleanable.getAddress().contains(address)) {
                addressMatch.add(cleanable);
            }
        }
        return addressMatch;
    }
    String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable cleanable: cleanables) {
            sb.append(cleanable.getAddress());
            sb.append(", ");
        }
        if (sb.length() > 0) return sb.substring(0, sb.length() -2);
        return sb.toString();
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aaaa, bbbbb, cccc, ");
        System.out.println(sb.substring(0, sb.length()-2));
    }
    public List<Cleanable> getCleanables() {
        return cleanables;
    }
}
