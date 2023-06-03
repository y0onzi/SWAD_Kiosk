
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    public void addItem (String menu, List<String> menuItem) {
        menuItem.add(menu);
    }

    public void removeItem(String menu, List<String> menuItem) {
        menuItem.remove(menu);
    }

    public void numOfOrder(List<String> menuItem, Map<String, Integer> numOfMenu) {
        Collections.sort(menuItem);
        int index=0;
        while (index < menuItem.size()) {
            numOfMenu.put(menuItem.get(index), Collections.frequency(menuItem, menuItem.get(index)));
            index += Collections.frequency(menuItem, menuItem.get(index));
        }
    }

    public int calculateTotalPrice(List<String> menuItem) {
        int price = 0;
        for (String menu: menuItem) {
//            price += getPrice(menu);
        }
        return price;
    }
}