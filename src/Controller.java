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
    
    public void getTotalPrice(){
        // System.out.println(price);
        // 카트 작성하시고 TotalPrice 연결시켜주세요
    }


    // 인벤토리 체크하고 요리까지 하는 클래스
    // 카트 작성하시고 안맞는 부분 있으면 수정해주세요
    // 한번에 한 메뉴랑 메뉴 개수까지...
    private void checkInventory(String menuItem, int number){
        if(menuItem=="KrabbyPatty" && inventory.inventoryStateofKrabbyPatty==true) {
            Cook.makeKrabbyPatty(number);
        }
        else {
            System.out.println("게살버거 주문 불가");
        }
        if(menuItem=="BulgogiBurger" && inventory.inventoryStateofBulgogiBurger==true) {
            Cook.makeBulgogiBurger(number);
        }
        else {
            System.out.println("불고기버거 주문 불가");
        }
        if(menuItem=="ChickenBurger" && inventory.inventoryStateofChickenBurger==true) {
            Cook.makeChickenBurger(number);
        }
        else {
            System.out.println("치킨버거 주문 불가");
        }
        if(menuItem=="FrenchFries" && inventory.inventoryStateofFrenchFries==true) {
            Cook.makeFrenchFries(number);
        }
        else {
            System.out.println("감자튀김 주문 불가");
        }
        if(menuItem=="CheeseStick" && inventory.inventoryStateofCheeseStick==true) {
            Cook.makeCheeseStick(number);
        }
        else {
            System.out.println("치즈스틱 주문 불가");
        }
        if(menuItem=="ChickenNuggets" && inventory.inventoryStateofChickenNuggets==true) {
            Cook.makeChickenNuggets(number);
        }
        else {
            System.out.println("치킨너겟 주문 불가");
        }
        if(menuItem=="Orangejuice" && inventory.inventoryStateofOrangejuice==true) {
            Cook.makeOrangejuice(number);
        }
        else {
            System.out.println("오렌지주스 주문 불가");
        }
        if(menuItem=="CocaCola" && inventory.inventoryStateofCocaCola==true) {
            Cook.makeCocaCola(number);
        }
        else {
            System.out.println("코카콜라 주문 불가");
        }
        if(menuItem=="Sprite" && inventory.inventoryStateofSprite==true) {
            Cook.makeSprite(number);
        }
        else {
            System.out.println("스프라이트 주문 불가");
        }
    }

    private void giveResults(){
        System.out.println("주문하신 ");
        // 주문내역 출력
        System.out.println("나왔습니다!");
    }

    public void returnKrabbyPatty(int number){
        System.out.println("게살버거 "+number+"개 ");
    }
    private void returnBulgogiBurger(int number){
        System.out.println("불고기버거 "+number+"개 ");
    }
    private void returnChickenBurger(int number){
        System.out.println("치킨버거 "+number+"개 ");
    }
    private void returnFrenchFries(int number){
        System.out.println("감자튀김 "+number+"개 ");
    }
    private void returnCheeseStick(int number){
        System.out.println("치즈스틱 "+number+"개 ");
    }
    private void returnChickenNuggets(int number){
        System.out.println("치킨너겟 "+number+"개 ");
    }
    private void returnOrangejuice(int number){
        System.out.println("오렌지주스 "+number+"개 ");
    }
    private void returnCocaCola(int number){
        System.out.println("게살버거 "+number+"개 ");
    }
    private void returnSprite(int number){
        System.out.println("게살버거 "+number+"개 ");
    }



}

