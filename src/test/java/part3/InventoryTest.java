package part3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void addGuitar() {
        Inventory inventory = new Inventory();
        inventory.addGuitar("123456", 999.99, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        assertEquals(inventory.getGuitar("123456").getPrice(), 999.99);
        assertEquals(inventory.getGuitar("123456").getModel(), "Stratocaster");
        assertNull(inventory.getGuitar("789012"));
        inventory.addGuitar("789012", 1499.99, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
        assertEquals(inventory.getGuitar("123456").getPrice(), 999.99);
        assertEquals(inventory.getGuitar("123456").getModel(), "Stratocaster");
        assertEquals(inventory.getGuitar("789012").getPrice(), 1499.99);
        assertEquals(inventory.getGuitar("789012").getModel(), "Les Paul");
    }

    @Test
    void getGuitar() {
        Inventory inventory = new Inventory();
        inventory.addGuitar("345678", 799.99, "Martin", "D-28", "Acoustic", "Rosewood", "Spruce");
        assertNotNull(inventory.getGuitar("345678"));
        assertNull(inventory.getGuitar("789012"));
        assertNull(inventory.getGuitar("901234"));
        inventory.addGuitar("901234", 599.99, "Taylor", "314ce", "Acoustic", "Sapele", "Sitka Spruce");
        assertNotNull(inventory.getGuitar("345678"));
        assertNotNull(inventory.getGuitar("901234"));
    }

    @Test
    void search() {
        Inventory inventory = new Inventory();
        Guitar searchGuitar = new Guitar("345678", 799.99, "Martin", "D-28", "Acoustic", "Rosewood", "Spruce");
        assertNull(inventory.search(searchGuitar));
        inventory.addGuitar("345678", 799.99, "Martin", "D-28", "Acoustic", "Rosewood", "Spruce");
        assertNotNull(inventory.search(searchGuitar));
        inventory = new Inventory();
        assertNull(inventory.search(searchGuitar));
    }
}