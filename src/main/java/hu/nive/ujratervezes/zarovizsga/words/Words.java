package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        if (s == null) {
            return false;
        }

        int digits = 0;
        int letters = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            } else {
                letters++;
            }
        }
        return digits > letters;
    }
}
