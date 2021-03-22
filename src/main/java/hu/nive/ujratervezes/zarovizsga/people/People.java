package hu.nive.ujratervezes.zarovizsga.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class People {

    public int getNumberOfMales(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            int males = 0;
            for(String line: lines) {
                String[] parts = line.split(",");
                if ("Male".equals(parts[4])) {
                    males ++;
                }
            }
            return males;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
