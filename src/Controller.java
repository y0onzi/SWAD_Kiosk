import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Screen screen;
    Wholemenu wholemenu;
    Cart cart;
    Inventory inventory;
    Takeout takeout;
    //BarcodeReader barcodeReader;
    CardReader cardReader;
    Receipt receipt;
    Printer printer;
    Cook cook;

    Scanner sc = new Scanner(System.in);

    private void ProcessPayment(){

        if(checkCouponUse()==0) useCoupon();
    }

    private int checkCouponUse(){
        System.out.println("쿠폰을 사용하고 사용하고 싶다면 0: \n 사용할 쿠폰이 없다면 1: ");
        int useCheck = sc.nextInt();
        return useCheck;
    }


    private void useCoupon(){
        String couponCode = sc.next();
        //버튼말고 키보드로 직접 입력 받기
        if(couponCode.equals("2023drinkfree")){
            System.out.println("음료수 무료 제공 쿠폰 적용완료!");
            //controller에서 가격조절필요
            //음료수 선택안했으면?
        }
        else if (couponCode.equals("2023discount50")){
            System.out.println("주문 가격에서 50퍼센트 할인 적용완료!");
            //controller에서 가격조절필요
        }
        else System.out.println("존재하지 않는 쿠폰입니다.");

    }
    
    // 인벤토리 체크하고 요리까지 하는 클래스
    // 메뉴 받아오는 거(String menu) 수정하는 게 좋을 듯... 카트 작성하시는 거 보고 맞추어 수정
    private void checkInventory(String menu, int number){
        if(menu=="KrabbyPatty" && inventory.inventoryStateofKrabbyPatty==true) {
            Cook.makeKrabbyPatty(number);
        }
        else {
            System.out.println("게살버거 주문 불가");
        }
        if(menu=="BulgogiBurger" && inventory.inventoryStateofBulgogiBurger==true) {
            Cook.makeBulgogiBurger(number);
        }
        else {
            System.out.println("불고기버거 주문 불가");
        }
        if(menu=="ChickenBurger" && inventory.inventoryStateofChickenBurger==true) {
            Cook.makeChickenBurger(number);
        }
        else {
            System.out.println("치킨버거 주문 불가");
        }
        if(menu=="FrenchFries" && inventory.inventoryStateofFrenchFries==true) {
            Cook.makeFrenchFries(number);
        }
        else {
            System.out.println("감자튀김 주문 불가");
        }
        if(menu=="CheeseStick" && inventory.inventoryStateofCheeseStick==true) {
            Cook.makeCheeseStick(number);
        }
        else {
            System.out.println("치즈스틱 주문 불가");
        }
        if(menu=="ChickenNuggets" && inventory.inventoryStateofChickenNuggets==true) {
            Cook.makeChickenNuggets(number);
        }
        else {
            System.out.println("치킨너겟 주문 불가");
        }
        if(menu=="Orangejuice" && inventory.inventoryStateofOrangejuice==true) {
            Cook.makeOrangejuice(number);
        }
        else {
            System.out.println("오렌지주스 주문 불가");
        }
        if(menu=="CocaCola" && inventory.inventoryStateofCocaCola==true) {
            Cook.makeCocaCola(number);
        }
        else {
            System.out.println("코카콜라 주문 불가");
        }
        if(menu=="Sprite" && inventory.inventoryStateofSprite==true) {
            Cook.makeSprite(number);
        }
        else {
            System.out.println("스프라이트 주문 불가");
        }
    }



}

