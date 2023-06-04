import javax.swing.*;

public class Controller {

    //메뉴클래스 연결
    public String[] createMenuInfoArray(WholeMenu wholeMenu) {
        return wholeMenu.createMenuInfoArray();
    } //선택한 메뉴 상세정보 텍스트배열 만들기

    public String getName(WholeMenu wholeMenu) {
        return wholeMenu.getName();
    }

    public double getPrice(WholeMenu wholeMenu) {
        return wholeMenu.getPrice();
    }


    //카트클래스 연결
    public JPanel getCartPanel(Cart cart) {
        return cart.getCartPanel();
    } //카트패널가져오기

    public String[] getCartMenus(Cart cart) {
        return cart.getSelectedMenus();
    }

    public Integer[] getQuantitiesOfCartMenus(Cart cart) {
        return cart.getMenuQuantities();
    }

    public Double[] getTotalPricesOfCartMenus(Cart cart) {
        return cart.getMenuTotalPrices();
    }

    public double getCartTotalPrice(Cart cart) {
        return cart.getTotal();
    }

    public double setCart(Cart cart, String name, double price) {
        return cart.setCart(name, price);
    } //카트 내용물 설정(새로운메뉴추가,이미있는메뉴수량추가)

    public void setTotalPrice(Cart cart, double total) {
        cart.setTotal(total);
    }

    public boolean isTakeout(Cart cart) {
        return cart.isTakeout();
    }




    //인벤토리클래스 연결
    public boolean isSoldOut(Inventory inventory,Cart cart) {
        return inventory.isSoldOut(cart);
    }

    public boolean getIsSoldOut(Inventory inventory){
        return inventory.getIsSoldOut();
    }


    //테이크아웃 클래스 연결
    public boolean getTakeout(Takeout takeout) {
        return takeout.getTakeout();
    }


    //바코드리더 클래스 연결
    public boolean useCoupon(BarcodeReader barcodeReader, Cart cart, String CouponCode) {
        return barcodeReader.useCoupon(cart, CouponCode);
    }

    public boolean getIsCouponUsed(BarcodeReader barcodeReader) {
        return barcodeReader.getIsCouponUsed();
    }

    //할인적용
    public void applyCouponAndGetPrice(Cart cart) {
        double originalPrice = getCartTotalPrice(cart);
        double discount = 0.5;
        double discountedPrice = originalPrice * (1 - discount);

        setTotalPrice(cart, discountedPrice);
    }

    //카드리더클래스 연결
    public boolean useCreditCard(CardReader cardReader, String password) {
        return cardReader.useCreditCard(password);
    }
}
