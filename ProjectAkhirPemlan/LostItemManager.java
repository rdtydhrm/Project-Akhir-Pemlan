import java.util.ArrayList;
import java.util.List;

public class LostItemManager {
    private List<LostItem> items = new ArrayList<>();

    public void addItem(LostItem item) {
        items.add(item);
    }

    public List<LostItem> getItems() {
        return items;
    }

    public List<LostItem> searchByName(String name) {
        List<LostItem> result = new ArrayList<>();
        for (LostItem item : items) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}
