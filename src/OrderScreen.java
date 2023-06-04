import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderScreen extends Screen {

    public OrderScreen() {

        // JFrame 설정
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setTitle("패스트푸드점 키오스크");
        setSize(850, 620);


        //전체 메뉴 레이아웃
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(190, 220, 240));
        contentPane.add(mainPanel, BorderLayout.CENTER);


        //전체메뉴타이틀
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가
        JLabel MenuTitle = new JLabel("[WholeMenu]");
        MenuTitle.setFont(new Font("돋움", Font.BOLD, 30));
        MenuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(MenuTitle);


        //버거메뉴타이틀
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가
        JLabel BurgerTitle = new JLabel("-Burger Menu-");
        BurgerTitle.setFont(new Font("돋움", Font.ITALIC, 15));
        BurgerTitle.setForeground(Color.GRAY);
        BurgerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(BurgerTitle);

        //버거메뉴레이아웃(전체메뉴에 포함)
        JPanel BurgerMenuPanel = new JPanel();
        BurgerMenuPanel.setLayout(new GridLayout(0, 3, 10, 10));
        BurgerMenuPanel.setPreferredSize(new Dimension(500, 160));
        BurgerMenuPanel.setBackground(new Color(190, 220, 240));


        JButton[] BurgerBtn = new JButton[3];

        for (int i = 0; i < 3; i++) {
            BurgerBtn[i] = new JButton("<html>" + controller.getName(burgers[i]) + "<br>(￦" + controller.getPrice(burgers[i]) + ")</html>");
            BurgerBtn[i].setFont(new Font("돋움", Font.BOLD, 14));
            BurgerMenuPanel.add(BurgerBtn[i]);
        }


        mainPanel.add(BurgerMenuPanel);

        //사이드메뉴타이틀
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); //컴포넌트사이간격추가
        JLabel SideTitle = new JLabel("-Side Menu-");
        SideTitle.setFont(new Font("돋움", Font.ITALIC, 15));
        SideTitle.setForeground(Color.GRAY);
        SideTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(SideTitle);

        //사이드메뉴레이아웃(전체메뉴에 포함)
        JPanel SideMenuPanel = new JPanel();
        SideMenuPanel.setLayout(new GridLayout(0, 3, 10, 10));
        SideMenuPanel.setPreferredSize(new Dimension(500, 160));
        SideMenuPanel.setBackground(new Color(190, 220, 240));

        JButton[] SideBtn = new JButton[3];

        for (int i = 0; i < 3; i++) {
            SideBtn[i] = new JButton("<html>" + controller.getName(sides[i]) + "<br>(￦" + controller.getPrice(sides[i]) + ")</html>");
            SideBtn[i].setFont(new Font("돋움", Font.BOLD, 14));
            SideMenuPanel.add(SideBtn[i]);
        }


        mainPanel.add(SideMenuPanel);


        //드링크메뉴타이틀
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); //컴포넌트사이간격추가
        JLabel DrinkTitle = new JLabel("-Drink Menu-");
        DrinkTitle.setFont(new Font("돋움", Font.ITALIC, 15));
        DrinkTitle.setForeground(Color.GRAY);
        DrinkTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(DrinkTitle);

        //드링크메뉴레이아웃(전체메뉴에 포함)
        JPanel DrinkMenuPanel = new JPanel();
        DrinkMenuPanel.setLayout(new GridLayout(0, 3, 10, 10));
        DrinkMenuPanel.setPreferredSize(new Dimension(500, 160));
        DrinkMenuPanel.setBackground(new Color(190, 220, 240));

        JButton[] DrinkBtn = new JButton[3];

        for (int i = 0; i < 3; i++) {
            DrinkBtn[i] = new JButton("<html>" + controller.getName(drinks[i]) + "<br>(￦" + +controller.getPrice(drinks[i]) + ")</html>");
            DrinkBtn[i].setFont(new Font("돋움", Font.BOLD, 14));
            DrinkMenuPanel.add(DrinkBtn[i]);
        }

        mainPanel.add(DrinkMenuPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); //컴포넌트사이간격추가
        //메뉴 상세정보 타이틀
        JLabel MenuInfoTitle = new JLabel("*Select Menu Information*");
        MenuInfoTitle.setFont(new Font("돋움", Font.BOLD, 15));
        MenuInfoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        MenuInfoTitle.setForeground(new Color(111, 111, 162));
        mainPanel.add(MenuInfoTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가

        //선택메뉴 상세정보 (최근선택메뉴의..)
        JPanel SelectMenuInfoPanel = new JPanel();
        SelectMenuInfoPanel.setLayout(new GridLayout(4, 0, 5, 5));
        SelectMenuInfoPanel.setPreferredSize(new Dimension(350, 80));


        JLabel[] MenuInfo = new JLabel[4];

        MenuInfo[0] = new JLabel(" 메뉴명: " + " ");
        MenuInfo[1] = new JLabel(" 가격: " + " ");
        MenuInfo[2] = new JLabel(" 칼로리: " + " ");
        MenuInfo[3] = new JLabel(" ");

        for (int i = 0; i < 4; i++) {
            MenuInfo[i].setFont(new Font("돋움", Font.ITALIC, 10));
            MenuInfo[i].setForeground(Color.GRAY);
            SelectMenuInfoPanel.add(MenuInfo[i]);
        }
        mainPanel.add(SelectMenuInfoPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가


        //서브패널레이아웃
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBackground(new Color(255, 250, 200));
        subPanel.setPreferredSize(new Dimension(350, 620));
        contentPane.add(subPanel, BorderLayout.EAST);

        //카트타이틀
        subPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        JLabel CartTitle = new JLabel("[Cart]");
        CartTitle.setFont(new Font("돋움", Font.BOLD, 30));
        CartTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subPanel.add(CartTitle);

        subPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가

        //카트패널
        Cart cart = new Cart(); //카트객체생성
        subPanel.add(controller.getCartPanel(cart));


        subPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        Integer[] totalPrice = new Integer[1];
        totalPrice[0] = 0;

        JLabel totalLabel = new JLabel("=Total: " + totalPrice[0]);
        totalLabel.setFont(new Font("돋움", Font.BOLD, 15));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subPanel.add(totalLabel);

        subPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        //결제버튼패널
        JPanel payPanel = new JPanel();
        payPanel.setLayout(new GridLayout(0, 2, 5, 5));
        payPanel.setBackground(new Color(255, 250, 200));


        JButton packagingSelectBtn1 = new JButton("먹고가기");
        packagingSelectBtn1.setFont(new Font("돋움", Font.BOLD, 14));
        payPanel.add(packagingSelectBtn1);

        JButton packagingSelectBtn2 = new JButton("포장");
        packagingSelectBtn2.setFont(new Font("돋움", Font.BOLD, 14));
        payPanel.add(packagingSelectBtn2);

        subPanel.add(payPanel);

        subPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가


        //메뉴버튼 구현
        for (int i = 0; i < 3; i++) {
            final int index = i;

            //버거메뉴버튼 동작
            BurgerBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //메뉴상세정보
                    for (int j = 0; j < 4; j++) {
                        MenuInfo[j].setText(controller.createMenuInfoArray(burgers[index])[j]);
                    }

                    double total = controller.setCart(cart, controller.getName(burgers[index]), controller.getPrice(burgers[index]));
                    totalLabel.setText("=Total: " + total);

                    controller.getCartPanel(cart).revalidate();
                    controller.getCartPanel(cart).repaint();
                }
            });

            //사이드메뉴 버튼 동작
            SideBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < 4; j++) {
                        MenuInfo[j].setText(controller.createMenuInfoArray(sides[index])[j]);
                    }

                    double total = controller.setCart(cart, controller.getName(sides[index]), controller.getPrice(sides[index]));
                    totalLabel.setText("=Total: " + total);

                    controller.getCartPanel(cart).revalidate();
                    controller.getCartPanel(cart).repaint();
                }
            });


            //드링크 메뉴 버튼 동작
            DrinkBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for (int j = 0; j < 4; j++) {
                        MenuInfo[j].setText(controller.createMenuInfoArray(drinks[index])[j]);
                    }

                    double total = controller.setCart(cart, controller.getName(drinks[index]), controller.getPrice(drinks[index]));
                    totalLabel.setText("=Total: " + total);

                    controller.getCartPanel(cart).revalidate();
                    controller.getCartPanel(cart).repaint();
                }
            });

        }

        //포장유무선택버튼 구현

        //먹고가기버튼
        packagingSelectBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Takeout takeout = new Takeout(false);
                cart.setTakeout(controller.getTakeout(takeout)); // 포장여부를 카트에 전달

                boolean hasSoldOutItem = false; // 품절된 아이템이 있는지 확인하는 변수

                for (int i = 0; i < 9; i++) {
                    if (controller.isSoldOut(inventories[i], cart)) {
                        hasSoldOutItem = true;
                        break; // 품절된 아이템이 있을 경우 루프 중단
                    }
                }

                if (hasSoldOutItem) {
                    dispose(); // 품절된 아이템이 있을 경우 현재 창 닫기
                } else {
                    Screen frame = new CouponScreen(cart);
                    frame.setVisible(true);
                    dispose(); // 현재 창 닫기
                }
            }
        });



        //포장하기버튼
        packagingSelectBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Takeout takeout = new Takeout(true);
                cart.setTakeout(controller.getTakeout(takeout));//포장여부를 카트에 전달
                boolean hasSoldOutItem = false; // 품절된 아이템이 있는지 확인하는 변수

                for (int i = 0; i < 9; i++) {
                    if (controller.isSoldOut(inventories[i], cart)) {
                        hasSoldOutItem = true;
                        break; // 품절된 아이템이 있을 경우 루프 중단
                    }
                }

                if (hasSoldOutItem) {
                    dispose(); // 품절된 아이템이 있을 경우 현재 창 닫기
                } else {
                    Screen frame = new CouponScreen(cart);
                    frame.setVisible(true);
                    dispose(); // 현재 창 닫기
                }
            }
        });


    }
}
