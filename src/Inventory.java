import javax.swing.*;

public class Inventory {

    private String itemName;
    private int itemCount;
    private boolean isSoldOut;

    //생성자
    public Inventory(WholeMenu wholeMenu, int itemCount) {
        this.itemCount = itemCount;
        this.itemName = wholeMenu.getName();
    }


    //아이템개수 오퍼레이션
    public int getItemCount() {
        return itemCount;
    }

    public boolean getIsSoldOut() {
        return isSoldOut;
    }

    public boolean isSoldOut(Cart cart) {
        boolean isSoldOut = false; // 품절 여부를 나타내는 변수

        for (int i = 0; i < 9; i++) {
            String selectedMenu = cart.getSelectedMenus()[i];
            if (selectedMenu != null && selectedMenu.equals(itemName)) {
                if (cart.getMenuQuantities()[i] >= itemCount) {
                    JOptionPane.showMessageDialog(null, itemName + "은(는) 품절입니다.");
                    isSoldOut = true;
                }
            }
        }

        return isSoldOut;
    }


}
