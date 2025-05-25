public class LostItem extends Item { // Inheritance (extends Item)
    public LostItem(String name, String description, String location, String date) { // Constructor
        super(name, description, location, date);
    }

    @Override
    public String getInfo() { // Polimorfisme (override abstract method)
        return getName() + " | " + getDescription() + " | " + getLocation() + " | " + getDate();
    }

    @Override
    public String toString() { // Polimorfisme (override method)
        return getInfo();
    }
}
