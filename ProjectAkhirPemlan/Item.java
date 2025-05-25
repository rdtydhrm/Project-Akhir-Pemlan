public abstract class Item { // abstract class
    private String name;
    private String description;
    private String location;
    private String date;

    // Constructor
    public Item(String name, String description, String location, String date) { // Constructor
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getDate() { return date; }

    public abstract String getInfo(); // abstract method (polimorfisme)
}
