public class LostItem extends Item {
    public LostItem(String name, String description, String location, String date) {
        super(name, description, location, date);
    }

    @Override
    public String getInfo() {
        return getName() + " | " + getDescription() + " | " + getLocation() + " | " + getDate();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
