import javax.swing.*;
import java.awt.*;

public class Printer extends Screen {
    private Cart cart;

    public Printer(BarcodeReader barcodeReader, Cart cart) {
        contentPane = getContentPane();
        this.cart = cart;

        contentPane.setLayout(new BorderLayout());
        this.setTitle("영수증");
        setSize(400, 620);


        //주문메뉴확인용패널
        JPanel orderMenuPanel = new JPanel();
        orderMenuPanel.setLayout(new BoxLayout(orderMenuPanel, BoxLayout.Y_AXIS));
        orderMenuPanel.setBackground(new Color(194, 194, 194));
        contentPane.add(orderMenuPanel, BorderLayout.CENTER);

        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 30))); //컴포넌트사이간격추가

        //주문메뉴타이틀
        JLabel orderMenuTitle = new JLabel("[영수증]");
        orderMenuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderMenuTitle.setFont(new Font("돋움", Font.BOLD, 20));
        orderMenuPanel.add(orderMenuTitle);


        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 30))); //컴포넌트사이간격추가

        //주문내역
        JPanel cartListPanel = new JPanel();
        cartListPanel.setBackground(new Color(218, 218, 218));
        cartListPanel.setLayout(new GridLayout(10, 1));


        JLabel[] cartList = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            cartList[i] = new JLabel(" ");
            cartList[i].setForeground(Color.GRAY);
            cartListPanel.add(cartList[i]);
        }

        String[] cartMenus = controller.getCartMenus(cart);
        Integer[] quantities = controller.getQuantitiesOfCartMenus(cart);
        Double[] totalPrices = controller.getTotalPricesOfCartMenus(cart);

        for (int i = 0; i < 9; i++) {
            if (cartMenus[i] != null)
                cartList[i].setText("   " + cartMenus[i] + "     개수: " + quantities[i] + "      총 ￦" + totalPrices[i]);
            cartListPanel.add(cartList[i]);
        }


        //만약 포장 선택 했을경우 포장금액 추가 표시
        if (controller.isTakeout(cart)) {
            cartList[9].setText("   포장금액 추가:   ￦100");
            cartListPanel.add(cartList[9]);
        }

        orderMenuPanel.add(cartListPanel);

        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        if (controller.getIsCouponUsed(barcodeReader)) {
            //쿠폰이 사용됐다면
            JLabel couponUsageLabel = new JLabel("50% 할인 쿠폰 사용");
            couponUsageLabel.setFont(new Font("돋움", Font.BOLD, 15));
            couponUsageLabel.setForeground(new Color(54, 86, 133));
            couponUsageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            orderMenuPanel.add(couponUsageLabel);
        }


        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        //총액
        JLabel totalPrice = new JLabel(controller.getCartTotalPrice(cart) + "원");
        totalPrice.setFont(new Font("돋움", Font.BOLD, 20));
        totalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderMenuPanel.add(totalPrice);
        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가


    }
}
