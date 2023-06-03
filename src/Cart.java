
import java.util.List;

public class Cart {
    public void addItem (String menu, List<String> menuItem) {
        menuItem.add(menu);
    }

    public void removeItem(String menu, List<String> menuItem) {
        menuItem.remove(menu);
    }

    public int calculateTotalPrice(List<String> menuItem) {
        int price = 0;
        for (String menu: menuItem) {
//            price += getPrice(menu);
        }
        return price;
    }
}