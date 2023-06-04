import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class PayScreen extends Screen {
    private Cart cart;
    private BarcodeReader barcodeReader;


    public PayScreen(BarcodeReader barcodeReader, Cart cart) {
        contentPane = getContentPane();
        this.cart = cart;
        this.barcodeReader = barcodeReader;

        contentPane.setLayout(new BorderLayout());
        this.setTitle("결제화면");
        setSize(850, 620);


        //주문메뉴확인용패널
        JPanel orderMenuPanel = new JPanel();
        orderMenuPanel.setLayout(new BoxLayout(orderMenuPanel, BoxLayout.Y_AXIS));
        orderMenuPanel.setBackground(new Color(185, 185, 208));
        contentPane.add(orderMenuPanel, BorderLayout.CENTER);

        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 30))); //컴포넌트사이간격추가

        //주문메뉴타이틀
        JLabel orderMenuTitle = new JLabel("[orderMenu]");
        orderMenuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderMenuTitle.setFont(new Font("돋움", Font.BOLD, 20));
        orderMenuPanel.add(orderMenuTitle);


        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 30))); //컴포넌트사이간격추가

        //주문내역
        JPanel cartListPanel = new JPanel();
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

        JLabel couponUsageLabel = new JLabel("쿠폰을 사용하지 않았습니다");
        couponUsageLabel.setFont(new Font("돋움", Font.BOLD, 10));
        couponUsageLabel.setForeground(new Color(54, 86, 133));
        couponUsageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderMenuPanel.add(couponUsageLabel);

        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        //총액
        JLabel totalPrice = new JLabel("Total: " + controller.getCartTotalPrice(cart));
        totalPrice.setFont(new Font("돋움", Font.BOLD, 20));
        totalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderMenuPanel.add(totalPrice);
        orderMenuPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        if (controller.getIsCouponUsed(barcodeReader)) {
            //쿠폰이 사용됐다면
            couponUsageLabel.setText("50퍼센트 할인 쿠폰이 적용된 가격");
        }

        //카드결제 패널

        JPanel CreditCardPanel = new JPanel();
        CreditCardPanel.setLayout(new BoxLayout(CreditCardPanel, BoxLayout.Y_AXIS));
        CreditCardPanel.setBackground(new Color(215, 221, 229));
        CreditCardPanel.setPreferredSize(new Dimension(300, 620));
        contentPane.add(CreditCardPanel, BorderLayout.EAST);

        CreditCardPanel.add(Box.createRigidArea(new Dimension(0, 200))); //컴포넌트사이간격추가

        //카드인식하기버튼
        JButton recognizeCardBtn = new JButton("카드인식");
        recognizeCardBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        CreditCardPanel.add(recognizeCardBtn);

        //비밀번호입력
        JLabel passwordLabel = new JLabel("비밀번호를 입력하세요");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setFont(new Font("돋움", Font.BOLD, 15));


        // 텍스트 입력 필드 생성
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setBackground(new Color(185, 185, 208));


        JTextField passwordField = new JTextField(50);
        passwordPanel.add(passwordField);


        CreditCardPanel.add(Box.createRigidArea(new Dimension(0, 50))); //컴포넌트사이간격추가

        //확인버튼
        JButton confilmBtn2 = new JButton("확인");
        confilmBtn2.setAlignmentX(Component.CENTER_ALIGNMENT);

        CardReader cardReader = new CardReader();

        //카드인식버튼동작 (인식되면 ui변경)
        recognizeCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "카드가 인식되었습니다");
                recognizeCardBtn.setVisible(false);//버튼 숨기기

                CreditCardPanel.add(passwordLabel);
                CreditCardPanel.add(Box.createRigidArea(new Dimension(0, 20))); //컴포넌트사이간격추가
                contentPane.add(passwordPanel, BorderLayout.CENTER);
                CreditCardPanel.add(passwordPanel);
                CreditCardPanel.add(Box.createRigidArea(new Dimension(0, 50))); //컴포넌트사이간격추가
                passwordPanel.add(confilmBtn2);
                CreditCardPanel.add(Box.createRigidArea(new Dimension(0, 200))); //컴포넌트사이간격추가
            }
        });

        confilmBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPassward = passwordField.getText();
                if (controller.useCreditCard(cardReader, inputPassward)) {
                    //비밀번호 일치할 경우
                    Screen frame = new Printer(barcodeReader, cart);  //카트객체 생성(다음스크린으로 전달)
                    Cook cook= new Cook(inventories,cart);
                    frame.setVisible(true);



                } else dispose(); //틀릴경우 키오스크프로그램 종료
            }
        });

    }
}
