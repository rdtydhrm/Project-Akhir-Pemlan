public abstract class Item {
    private String name;
    private String description;
    private String location;
    private String date;

    public Item(String name, String description, String location, String date) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getDate() { return date; }

    public abstract String getInfo();
}
