package part3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        guitars = new ArrayList<>();
        try {
            FileWriter writer = new FileWriter("guitars_database.txt", false);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        /**
         * takes variables and appends guitar to the list and file.
         */
        if (getGuitar(serialNumber) != null) {
            // cannot add the same serial number twice
            return;
        }
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
        try {
            FileWriter writer = new FileWriter("guitars_database.txt", true);
            writer.write(serialNumber + "," + price + "," + builder + "," + model + "," + type + "," + backWood + "," + topWood + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Guitar getGuitar(String serialNumber) {
        /**
         * checks if a guitar of a given serial number exists, returns null otherwise
         */
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public Guitar search(Guitar searchGuitar) {
        /**
         * checks if a given guitar exists
         *
         */
        for (Guitar guitar : guitars) {
            if (Double.compare(guitar.getPrice(), searchGuitar.getPrice()) == 0 && Objects.equals(searchGuitar.getSerialNumber(), guitar.getSerialNumber()) && Objects.equals(searchGuitar.getBuilder(), guitar.getBuilder()) && Objects.equals(searchGuitar.getModel(), guitar.getModel()) && Objects.equals(searchGuitar.getType(), guitar.getType()) && Objects.equals(searchGuitar.getBackWood(), guitar.getBackWood()) && Objects.equals(searchGuitar.getTopWood(), guitar.getTopWood())) {
                return searchGuitar;
            }
        }
        return null;
    }

}
