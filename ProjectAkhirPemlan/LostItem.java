public class LostItem {
    private String name;
    private String description;
    private String location;
    private String date;

    public LostItem(String name, String description, String location, String date) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return name + " | " + description + " | " + location + " | " + date;
    }
}
