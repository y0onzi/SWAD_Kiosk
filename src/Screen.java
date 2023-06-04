import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Screen extends JFrame {
    //    JFrame frame = this;
    Container contentPane;
    Controller controller = new Controller();


    //메뉴 객체 생성(어디로 옮겨야하지..)
    Burger burger1 = new Burger("게살버거", 5000, 552, "바다향이 나는 게살과 치즈의 조합을 살린 버거메뉴");
    Burger burger2 = new Burger("불고기버거", 4700, 476, "소스의 강렬한 맛이 일품인 오리지날 버거메뉴");
    Burger burger3 = new Burger("치킨버거", 3900, 334, "가게의 대표 메뉴로 야채의 맛을 살린 신선한 버거메뉴");
    Burger[] burgers = {burger1, burger2, burger3};

    Drink drink1 = new Drink("오렌지주스", 2000, 84, 175);
    Drink drink2 = new Drink("콜라", 3000, 143, 310);
    Drink drink3 = new Drink("아메리카노", 1500, 9, 250);
    Drink[] drinks = {drink1, drink2, drink3};


    Side side1 = new Side("감자튀김", 2800, 229, "새콤달콤한 케찹과 함께 먹으면 더 맛있는 감자튀김");
    Side side2 = new Side("치즈스틱", 1500, 143, "쭈욱 늘어나는 치즈에 행복을 더한 치즈스틱");
    Side side3 = new Side("치킨너겟", 3000, 171, "공룡모양의 귀여운 치킨너겟 4조각");
    Side[] sides = {side1, side2, side3};
    Inventory inventoryOfBurger1 = new Inventory(burger1,10);
    Inventory inventoryOfBurger2 = new Inventory(burger2,10);
    Inventory inventoryOfBurger3 = new Inventory(burger3,10);
    Inventory inventoryOfDrink1 = new Inventory(drink1,10);
    Inventory inventoryOfDrink2 = new Inventory(drink2,10);
    Inventory inventoryOfDrink3 = new Inventory(drink3,10);
    Inventory inventoryOfSide1 = new Inventory(side1,10);
    Inventory inventoryOfSide2 = new Inventory(side2,10);
    Inventory inventoryOfSide3 = new Inventory(side3,10);

    Inventory[] inventories= {inventoryOfBurger1,inventoryOfBurger2,inventoryOfBurger3,
            inventoryOfDrink1,inventoryOfDrink2,inventoryOfDrink3,
            inventoryOfSide1,inventoryOfSide2,inventoryOfSide3};

    public Screen() {
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setTitle("메인화면");
        setSize(850, 620);

    }

    public static void main(String[] args) {
        Screen frame = new OrderScreen();
        frame.setVisible(true);

    }
}

