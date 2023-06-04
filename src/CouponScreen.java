import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CouponScreen extends Screen {
    private Cart cart;


    public CouponScreen(Cart cart) {
        contentPane = getContentPane();

        BarcodeReader barcodeReader = new BarcodeReader();
        this.cart = cart;
        this.setTitle("쿠폰사용");
        setSize(500, 620);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        this.setContentPane(contentPane);


        JPanel couponPanel = new JPanel();
        couponPanel.setLayout(new BoxLayout(couponPanel, BoxLayout.Y_AXIS));
        couponPanel.setBackground(new Color(215, 221, 229));

        contentPane.add(couponPanel, BorderLayout.WEST);


        couponPanel.add(Box.createRigidArea(new Dimension(0, 100))); //컴포넌트사이간격추가


        //쿠폰패널타이틀
        JLabel couponTitle = new JLabel("쿠폰 사용");
        couponTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        couponTitle.setFont(new Font("돋움", Font.BOLD, 20));
        couponPanel.add(couponTitle);

        couponPanel.add(Box.createRigidArea(new Dimension(0, 150))); //컴포넌트사이간격추가


        // 텍스트 입력 필드 생성
        JPanel couponTextPanel = new JPanel();
        couponTextPanel.setLayout(new BoxLayout(couponTextPanel, BoxLayout.Y_AXIS));
        couponTextPanel.setBackground(new Color(185, 185, 208));
        contentPane.add(couponTextPanel, BorderLayout.CENTER);

        JTextField couponTextField = new JTextField(50);
        couponTextPanel.add(couponTextField);
        couponPanel.add(couponTextField);


        couponPanel.add(Box.createRigidArea(new Dimension(0, 50))); //컴포넌트사이간격추가


        //쿠폰사용,미사용 버튼 추가

        JButton confilmBtn = new JButton("확인");
        confilmBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        couponPanel.add(confilmBtn); //확인버튼 추가


        couponPanel.add(Box.createRigidArea(new Dimension(0, 20))); //컴포넌트사이간격추가

        JButton unusedBtn = new JButton("쿠폰을 사용하지 않습니다");
        unusedBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        couponPanel.add(unusedBtn); //확인버튼 추가

        couponPanel.add(Box.createRigidArea(new Dimension(0, 400))); //컴포넌트사이간격추가


        //쿠폰입력확인버튼 동작
        confilmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputCode = couponTextField.getText();
                if (controller.useCoupon(barcodeReader, cart, inputCode)) {
                    controller.applyCouponAndGetPrice(cart); //50프로 할인 적용

                    Screen frame = new PayScreen(barcodeReader, cart);  // 다음스크린으로 전달
                    frame.setVisible(true);
                    dispose();
                }
            }
        });

        //쿠폰미사용 버튼 동작 구현
        unusedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen frame = new PayScreen(barcodeReader, cart);  // 다음스크린으로 전달
                frame.setVisible(true);
                dispose();
            }
        });
    }


}
