import java.util.*;
import java.io.*;

public class LostItemManager {
    private List<Item> items = new ArrayList<>(); // Collection (List), Asosiasi ke Item
    private static final String FILE_NAME = "data_barang.txt";

    public LostItemManager() { // Constructor
        loadFromFile();
    }

    public void addItem(Item item) { // Asosiasi: menerima objek Item
        items.add(item);
        saveToFile();
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Item> searchByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    // Simpan semua data ke file
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Item item : items) {
                pw.println(item.getName() + "|" + item.getDescription() + "|" + item.getLocation() + "|" + item.getDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Baca data dari file
    public void loadFromFile() {
        items.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    items.add(new LostItem(parts[0], parts[1], parts[2], parts[3])); // Asosiasi: membuat objek LostItem
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public java.util.List<Item> getAllItems() {
        return items;}
}
