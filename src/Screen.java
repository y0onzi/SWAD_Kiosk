import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Screen extends JFrame {
    //    JFrame frame = this;
    Container contentPane;
    private JPanel CartPanel;
    private JLabel[] CartList;


    public Screen() {


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


        String[][] ExampleFoodInfo1 = new String[3][3];
        ExampleFoodInfo1[0][0] = "게살버거";
        ExampleFoodInfo1[0][1] = "4000";
        ExampleFoodInfo1[0][2] = "500";

        ExampleFoodInfo1[1][0] = "불고기버거";
        ExampleFoodInfo1[1][1] = "3000";
        ExampleFoodInfo1[1][2] = "400";

        ExampleFoodInfo1[2][0] = "치킨버거";
        ExampleFoodInfo1[2][1] = "6000";
        ExampleFoodInfo1[2][2] = "300";


        String[][] ExampleFoodInfo2 = new String[3][3];
        ExampleFoodInfo2[0][0] = "감자튀김";
        ExampleFoodInfo2[0][1] = "4000";
        ExampleFoodInfo2[0][2] = "500";

        ExampleFoodInfo2[1][0] = "치즈스틱";
        ExampleFoodInfo2[1][1] = "3000";
        ExampleFoodInfo2[1][2] = "400";

        ExampleFoodInfo2[2][0] = "치킨너겟";
        ExampleFoodInfo2[2][1] = "6000";
        ExampleFoodInfo2[2][2] = "300";

        String[][] ExampleFoodInfo3 = new String[3][3];
        ExampleFoodInfo3[0][0] = "오렌지주스";
        ExampleFoodInfo3[0][1] = "4000";
        ExampleFoodInfo3[0][2] = "500";

        ExampleFoodInfo3[1][0] = "코카콜라";
        ExampleFoodInfo3[1][1] = "3000";
        ExampleFoodInfo3[1][2] = "400";

        ExampleFoodInfo3[2][0] = "스프라이트";
        ExampleFoodInfo3[2][1] = "2000";
        ExampleFoodInfo3[2][2] = "0";


        JButton[] BurgerBtn = new JButton[3];//나중에 삭제

        for (int i = 0; i < 3; i++) {
            BurgerBtn[i] = new JButton("<html>" + ExampleFoodInfo1[i][0] + "<br>(￦" + ExampleFoodInfo1[i][1] + ")</html>");
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

        JButton[] SideBtn = new JButton[3];//나중에 삭제

        for (int i = 0; i < 3; i++) {
            SideBtn[i] = new JButton("<html>" + ExampleFoodInfo2[i][0] + "<br>(￦" + ExampleFoodInfo2[i][1] + ")</html>");
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

        JButton[] DrinkBtn = new JButton[3];//나중에 삭제

        for (int i = 0; i < 3; i++) {
            DrinkBtn[i] = new JButton("<html>" + ExampleFoodInfo3[i][0] + "<br>(￦" + ExampleFoodInfo3[i][1] + ")</html>");
            DrinkBtn[i].setFont(new Font("돋움", Font.BOLD, 14));
            DrinkMenuPanel.add(DrinkBtn[i]);
        }


        mainPanel.add(DrinkMenuPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); //컴포넌트사이간격추가
        //메뉴정보 타이틀
        JLabel MenuInfoTitle = new JLabel("*Select Menu Information*");
        MenuInfoTitle.setFont(new Font("돋움", Font.BOLD, 15));
        MenuInfoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        MenuInfoTitle.setForeground(new Color(111, 111, 162));
        mainPanel.add(MenuInfoTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가

        //선택메뉴 정보 (최근선택메뉴)
        JPanel SelectMenuInfoPanel = new JPanel();
        SelectMenuInfoPanel.setLayout(new GridLayout(3, 0, 5, 5));
        SelectMenuInfoPanel.setPreferredSize(new Dimension(350, 80));


        JLabel[] MenuInfo = new JLabel[3];

        MenuInfo[0] = new JLabel(" 메뉴명: " + " ");
        MenuInfo[1] = new JLabel(" 가격: " + " ");
        MenuInfo[2] = new JLabel(" 칼로리: " + " ");

        for (int i = 0; i < 3; i++) {
            MenuInfo[i].setFont(new Font("돋움", Font.ITALIC, 10));
            MenuInfo[i].setForeground(Color.GRAY);
            SelectMenuInfoPanel.add(MenuInfo[i]);
        }
        mainPanel.add(SelectMenuInfoPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가


        //서브패널레이아웃
        JPanel SubPanel = new JPanel();
        SubPanel.setLayout(new BoxLayout(SubPanel, BoxLayout.Y_AXIS));
        SubPanel.setBackground(new Color(255, 250, 200));
        SubPanel.setPreferredSize(new Dimension(350, 620));
        contentPane.add(SubPanel, BorderLayout.EAST);
        //카트타이틀

        SubPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        JLabel CartTitle = new JLabel("[Cart]");
        CartTitle.setFont(new Font("돋움", Font.BOLD, 30));
        CartTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        SubPanel.add(CartTitle);

        SubPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가

        //카트패널
        initializeCartPanel();
        SubPanel.add(CartPanel);


        SubPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        Integer[] totalPrice = new Integer[1];
        totalPrice[0]=0;

        JLabel total = new JLabel("=Total: " + totalPrice[0]);
        total.setFont(new Font("돋움", Font.BOLD, 15));
        total.setAlignmentX(Component.CENTER_ALIGNMENT);
        SubPanel.add(total);

        SubPanel.add(Box.createRigidArea(new Dimension(0, 10))); //컴포넌트사이간격추가

        //결제버튼패널
        JPanel PayPanel = new JPanel();
        PayPanel.setLayout(new GridLayout(0, 2, 5, 5));
        PayPanel.setBackground(new Color(255, 250, 200));


        JButton PayBtn1 = new JButton("먹고가기");
        PayBtn1.setFont(new Font("돋움", Font.BOLD, 14));
        PayPanel.add(PayBtn1);

        JButton PayBtn2 = new JButton("포장");
        PayBtn2.setFont(new Font("돋움", Font.BOLD, 14));
        PayPanel.add(PayBtn2);

        SubPanel.add(PayPanel);

        SubPanel.add(Box.createRigidArea(new Dimension(0, 5))); //컴포넌트사이간격추가

        String[] SelectMenu = new String[9];
        Integer[] SelectQuantity = new Integer[9];
        Integer[] SelectTotalPrice = new Integer[9];

        Arrays.fill(SelectQuantity, 0);
        Arrays.fill(SelectTotalPrice, 0);

        //버튼 동작 추가!
        for (int i = 0; i < 3; i++) {
            final int index = i;
            BurgerBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MenuInfo[0].setText(" 메뉴명: " + ExampleFoodInfo1[index][0]);
                    MenuInfo[1].setText(" 가격: ￦" + ExampleFoodInfo1[index][1]);
                    MenuInfo[2].setText(" 칼로리: " + ExampleFoodInfo1[index][2]);

                    for (int j = 0; j < 9; j++) {
                        if (ExampleFoodInfo1[index][0] == SelectMenu[j]) {
                            SelectQuantity[j] += 1;
                            SelectTotalPrice[j] += Integer.parseInt(ExampleFoodInfo1[index][1]);
                            totalPrice[0]+=Integer.parseInt(ExampleFoodInfo1[index][1]);
                            total.setText("=Total: " + totalPrice[0]);
                            CartList[j].setText(SelectMenu[j] + "     개수: " + SelectQuantity[j] + "      총 ￦" + (SelectTotalPrice[j]));
                            return;
                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        if (CartList[k].getText().isEmpty()) {
                            SelectMenu[k] = ExampleFoodInfo1[index][0];
                            SelectQuantity[k] = 1;
                            SelectTotalPrice[k] = Integer.parseInt(ExampleFoodInfo1[index][1]);
                            totalPrice[0]+=Integer.parseInt(ExampleFoodInfo1[index][1]);
                            total.setText("=Total: " + totalPrice[0]);
                            CartList[k].setText(SelectMenu[k] + "     개수: " + SelectQuantity[k] + "      총 ￦" + (SelectTotalPrice[k]));
                            return;
                        }
                    }
                    CartPanel.revalidate();
                    CartPanel.repaint();
                }
            });


            SideBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MenuInfo[0].setText(" 메뉴명: " + ExampleFoodInfo2[index][0]);
                    MenuInfo[1].setText(" 가격: ￦" + ExampleFoodInfo2[index][1]);
                    MenuInfo[2].setText(" 칼로리: " + ExampleFoodInfo2[index][2]);

                    for (int j = 0; j < 9; j++) {
                        if (ExampleFoodInfo2[index][0] == SelectMenu[j]) {
                            SelectQuantity[j] += 1;
                            SelectTotalPrice[j] += Integer.parseInt(ExampleFoodInfo2[index][1]);
                            totalPrice[0]+=Integer.parseInt(ExampleFoodInfo2[index][1]);
                            total.setText("=Total: " + totalPrice[0]);
                            CartList[j].setText(SelectMenu[j] + "     개수: " + SelectQuantity[j] + "      총 ￦" + (SelectTotalPrice[j]));
                            return;
                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        if (CartList[k].getText().isEmpty()) {
                            SelectMenu[k] = ExampleFoodInfo2[index][0];
                            SelectQuantity[k] = 1;
                            SelectTotalPrice[k] = Integer.parseInt(ExampleFoodInfo2[index][1]);
                            totalPrice[0]+=Integer.parseInt(ExampleFoodInfo2[index][1]);
                            total.setText("=Total: " + totalPrice[0]);
                            CartList[k].setText(SelectMenu[k] + "     개수: " + SelectQuantity[k] + "      총 ￦" + (SelectTotalPrice[k]));
                            return;
                        }
                    }
                    CartPanel.revalidate();
                    CartPanel.repaint();
                }
            });


            DrinkBtn[i].

                    addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MenuInfo[0].setText(" 메뉴명: " + ExampleFoodInfo3[index][0]);
                            MenuInfo[1].setText(" 가격: ￦" + ExampleFoodInfo3[index][1]);
                            MenuInfo[2].setText(" 칼로리: " + ExampleFoodInfo3[index][2]);

                            for (int j = 0; j < 9; j++) {
                                if (ExampleFoodInfo3[index][0] == SelectMenu[j]) {
                                    SelectQuantity[j] += 1;
                                    SelectTotalPrice[j] += Integer.parseInt(ExampleFoodInfo3[index][1]);
                                    totalPrice[0]+=Integer.parseInt(ExampleFoodInfo3[index][1]);
                                    total.setText("=Total: " + totalPrice[0]);
                                    CartList[j].setText(SelectMenu[j] + "     개수: " + SelectQuantity[j] + "      총 ￦" + (SelectTotalPrice[j]));
                                    return;
                                }
                            }

                            for (int k = 0; k < 9; k++) {
                                if (CartList[k].getText().isEmpty()) {
                                    SelectMenu[k] = ExampleFoodInfo3[index][0];
                                    SelectQuantity[k] = 1;
                                    SelectTotalPrice[k] = Integer.parseInt(ExampleFoodInfo3[index][1]);
                                    totalPrice[0]+=Integer.parseInt(ExampleFoodInfo3[index][1]);
                                    total.setText("=Total: " + totalPrice[0]);
                                    CartList[k].setText(SelectMenu[k] + "     개수: " + SelectQuantity[k] + "      총 ￦" + (SelectTotalPrice[k]));
                                    return;
                                }
                            }
                            CartPanel.revalidate();
                            CartPanel.repaint();
                        }
                    });

        }


    }
    
    public class Inventory {
        static int numOfKrabbyPatty = 100,
                numOfBulgogiBurger = 100,
                numOfChickenBurger = 100,
                numOfFrenchFries = 100,
                numOfCheeseStick = 100,
                numOfChickenNuggets = 100,
                amountOfOrangejuice = 100,
                amountOfCocaCola = 100,
                amountOfSprite = 100;

        int KrabbyPatty = 0;
        int BulgogiBurger = 0;
        int ChickenBurger = 0;
        int FrenchFries = 0;
        int CheeseStick = 0;
        int ChickenNuggets = 0;
        int Orangejuice = 0;
        int CocaCola = 0;
        int Sprite = 0;
        boolean inventoryStateofKrabbyPatty = true;
        boolean inventoryStateofBulgogiBurger = true;
        boolean inventoryStateofChickenBurger = true;
        boolean inventoryStateofFrenchFries = true;
        boolean inventoryStateofCheeseStick = true;
        boolean inventoryStateofChickenNuggets = true;
        boolean inventoryStateofOrangejuice = true;
        boolean inventoryStateofCocaCola = true;
        boolean inventoryStateofSprite = true;


        public static int getIng(int k) {
            if(k == 0)
                return numOfKrabbyPatty;
            else if(k == 1)
                return numOfBulgogiBurger;
            else if(k == 2)
                return numOfChickenBurger;
            else if(k == 3)
                return numOfFrenchFries;
            else if(k == 4)
                return numOfCheeseStick;
            else if(k == 5)
                return numOfChickenNuggets;
            else if(k == 6)
                return amountOfOrangejuice;
            else if(k == 7)
                return amountOfCocaCola;
            else
                return amountOfSprite;
        }

        public int getKrabbyPatty() {
            return KrabbyPatty;
        }
        public int getBulgogiBurger() {
            return BulgogiBurger;
        }
        public int getChickenBurger() {
            return ChickenBurger;
        }
        public int getFrenchFries() {
            return FrenchFries;
        }
        public int getCheeseStick() {
            return CheeseStick;
        }
        public int getChickenNuggets() {
            return ChickenNuggets;
        }
        public int getOrangejuice() {
            return Orangejuice;
        }
        public int getCocaCola() {
            return CocaCola;
        }
        public int getSprite() {
            return Sprite;
        }

        public boolean getCheckStateofKrabbyPatty() {
            return inventoryStateofKrabbyPatty;
        }
        public boolean getCheckStateofBulgogiBurger() {
            return inventoryStateofBulgogiBurger;
        }
        public boolean getCheckStateofChickenBurger() {
            return inventoryStateofChickenBurger;
        }
        public boolean getCheckStateofFrenchFries() {
            return inventoryStateofFrenchFries;
        }
        public boolean getCheckStateofCheeseStick() {
            return inventoryStateofCheeseStick;
        }
        public boolean getCheckStateofChickenNuggets() {
            return inventoryStateofChickenNuggets;
        }
        public boolean getCheckStateofOrangejuice() {
            return inventoryStateofOrangejuice;
        }
        public boolean getCheckStateofCocaCola() {
            return inventoryStateofCocaCola;
        }
        public boolean getCheckStateofSprite() {
            return inventoryStateofSprite;
        }

        public void setInventoryState(int KrabbyPatty, int BulgogiBurger, int ChickenBurger, int FrenchFries, int CheeseStick, int ChickenNuggets, int Orangejuice, int CocaCola, int Sprite) {
            this.KrabbyPatty = KrabbyPatty;
            this.BulgogiBurger = BulgogiBurger;
            this.ChickenBurger = ChickenBurger;
            this.FrenchFries = FrenchFries;
            this.CheeseStick = CheeseStick;
            this.ChickenNuggets = ChickenNuggets;
            this.Orangejuice = Orangejuice;
            this.CocaCola = CocaCola;
            this.Sprite = Sprite;

            // 재고 없으면 인벤상태 false
            inventoryStateofKrabbyPatty = numOfKrabbyPatty - KrabbyPatty >= 0;
            inventoryStateofBulgogiBurger = numOfBulgogiBurger - BulgogiBurger >= 0;
            inventoryStateofChickenBurger = numOfChickenBurger - ChickenBurger >= 0;
            inventoryStateofFrenchFries = numOfFrenchFries - FrenchFries >= 0;
            inventoryStateofCheeseStick = numOfCheeseStick - CheeseStick >= 0;
            inventoryStateofChickenNuggets = numOfChickenNuggets - ChickenNuggets >= 0;
            inventoryStateofOrangejuice = amountOfOrangejuice - Orangejuice >= 0;
            inventoryStateofCocaCola = amountOfCocaCola - CocaCola >= 0;
            inventoryStateofSprite = amountOfSprite - Sprite >= 0;
        }

        static public void updateInventory(int KrabbyPatty, int BulgogiBurger, int ChickenBurger, int FrenchFries, int CheeseStick, int ChickenNuggets, int Orangejuice, int CocaCola, int Sprite) {
            numOfKrabbyPatty+=KrabbyPatty;
            numOfBulgogiBurger+=BulgogiBurger;
            numOfChickenBurger+=ChickenBurger;
            numOfFrenchFries+=FrenchFries;
            numOfCheeseStick+=CheeseStick;
            numOfChickenNuggets+=ChickenNuggets;
            amountOfOrangejuice+=Orangejuice;
            amountOfCocaCola+=CocaCola;
            amountOfSprite+=Sprite;

        }
    }

    public class Printer {
        int selectionData; // 연결 필요
        public void printReceipt() {
            JOptionPane.showMessageDialog(null, "영수증:" + selectionData ); // 팝업창, 내용 추가(연결) 필요
        }

    }

    public class Cook {
        int selectionData; // 연결 필요

        public void Cook(int selectionData) {
            this.selectionData = selectionData;
        }
        public void makeKrabbyPatty(int KrabbyPatty) {
            Inventory.numOfKrabbyPatty-=KrabbyPatty;
        }
        public void makeDrink(int BulgogiBurger) {
            Inventory.numOfBulgogiBurger-=BulgogiBurger;
        }
        public void makeFrenchFries(int FrenchFries) {
            Inventory.numOfFrenchFries-=FrenchFries;
        }
        public void makeCheeseStick(int CheeseStick) {
            Inventory.numOfCheeseStick-=CheeseStick;
        }
        public void makeChickenNuggets(int ChickenNuggets) {
            Inventory.numOfChickenNuggets-=ChickenNuggets;
        }
        public void makeOrangejuice(int Orangejuice) {
            Inventory.amountOfOrangejuice-=Orangejuice;
        }
        public void makeCocaCola(int CocaCola) {
            Inventory.amountOfCocaCola-=CocaCola;
        }
        public void Sprite(int Sprite) {
            Inventory.amountOfSprite-=Sprite;
        }
    }


    private void initializeCartPanel() {
        CartPanel = new JPanel();
        CartPanel.setLayout(new GridLayout(9, 0, 10, 10));
        CartPanel.setPreferredSize(new Dimension(350, 440));

        CartList = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            CartList[i] = new JLabel("");
            CartList[i].setForeground(Color.GRAY);
            CartPanel.add(CartList[i]);
        }
    }

    public static void main(String[] args) {
        Screen frame = new Screen();
        frame.setVisible(true);
    }
}

