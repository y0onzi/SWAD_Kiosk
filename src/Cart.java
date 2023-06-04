import javax.swing.*;
import java.awt.*;

public class Cart {
    private JPanel cartPanel;
    private JLabel[] CartList;
    private String[] selectedMenus;
    private Integer[] menuQuantities;
    private Double[] menuTotalPrices;
    private double total;
    private boolean isTakeout;

    //생성자

    public Cart() {
        selectedMenus = new String[9];
        menuQuantities = new Integer[9];
        menuTotalPrices = new Double[9];
        total = 0;
        initializeCartPanel();
    }


    //카트패널초기화
    public void initializeCartPanel() {
        cartPanel = new JPanel();
        cartPanel.setLayout(new GridLayout(9, 0, 10, 10));
        cartPanel.setPreferredSize(new Dimension(350, 440));

        CartList = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            CartList[i] = new JLabel("");
            CartList[i].setForeground(Color.GRAY);
            cartPanel.add(CartList[i]);
        }
    }

    public JPanel getCartPanel() {
        return cartPanel;
    }

    public String[] getSelectedMenus() {
        return selectedMenus;
    }

    public Integer[] getMenuQuantities() {
        return menuQuantities;
    }

    public Double[] getMenuTotalPrices() {
        return menuTotalPrices;
    }

    public double getTotal() {
        return total;
    }

    // 테이크아웃 여부 설정
    public void setTakeout(boolean isTakeout) {
        this.isTakeout = isTakeout;
        this.total+=100;
    }

    public void setTotal(double total){
        this.total=total;
    }

    // 테이크아웃 여부 반환
    public boolean isTakeout() {
        return isTakeout;
    }


    public double setCart(String name, Double price) {
        // 이미 고른 메뉴일 경우에 개수추가, 총액추가
        for (int i = 0; i < 9; i++) {
            if (name.equals(selectedMenus[i])) {
                menuQuantities[i] += 1;
                menuTotalPrices[i] += price;
                total += price;
                CartList[i].setText(selectedMenus[i] + "     개수: " + menuQuantities[i] + "      총 ￦" + (menuTotalPrices[i]));
                return total; // 이미 고른 메뉴일 경우에는 바로 함수 종료
            }
        }

        // 처음 고른 메뉴일 경우에 카트에 새로 추가
        for (int j = 0; j < 9; j++) {
            if (CartList[j].getText().isEmpty()) {
                selectedMenus[j] = name;
                menuQuantities[j] = 1;
                menuTotalPrices[j] = price;
                total += price;
                CartList[j].setText(selectedMenus[j] + "     개수: " + menuQuantities[j] + "      총 ￦" + (menuTotalPrices[j]));
                break;
            }
        }

        return total;
    }


}
