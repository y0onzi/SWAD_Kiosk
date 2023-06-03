import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Screen screen;
    Wholemenu wholemenu;
    Cart cart;
    Inventory inventory;
    Takeout takeout;
    BarcodeReader barcodeReader;
    CardReader cardReader;
    Receipt receipt;
    Printer printer;
    Cook cook;

    Scanner sc = new Scanner(System.in);
    double price=0;
    List<String> selectionMenu = new ArrayList<>();


    //결제 과정 진행 -> 아직 호출X
    public void processPayment(){
        //1. 먼저 쿠폰 사용 여부 확인 + 사용
        if(checkCouponUse()==0){
            System.out.println("쿠폰코드를 입력하세요: ");
            String couponCode = sc.next();
            //쿠폰 코드 버튼말고 키보드로 문자열 형태로 직접 입력 받음
            barcodeReader.readCoupon(couponCode);
        }
        //2.  카드 사용
        System.out.println("공백없이 카드번호를 입력해주세요: ");
        String cardNum = sc.next();
        System.out.println("카드 비밀번호를 입력해주세요: ");
        int cardPwd = sc.nextInt();
        cardReader.readCreditCard(cardNum, cardPwd);

        //3. 영수증 출력
        //최종 메뉴랑 가격 매개변수로 전달해야합니다!!
        // 일단 추가했는데 맞는지는 모르겠습니다
        // -> 매개변수 넣게 되면 processPayment 밖으로 빼거나
        //processPayment에 매개변수 전달 필요
        price= getTotalPrice();
        selectionMenu = getSelectionMenu();
        receipt.printReceipt(selectionMenu, price);


    }

    //포장유무 확인
    public void checkTakeout(){
        System.out.println(" 먹고가기 0: \n 포장하기 1: ");
        int takeoutCheck = sc.nextInt();
        takeout.setTakeout(takeoutCheck);
    }

    //쿠폰 사용 여부 확인
    private int checkCouponUse(){
        System.out.println("쿠폰을 사용하고 사용하고 싶다면 0: \n 사용할 쿠폰이 없다면 1: ");
        int useCheck = sc.nextInt();
        return useCheck;
    }

    //쿠폰 적용시 가격 조정(할인) -> barcodeReader에서 호출!
    public double applyCouponAndGetPrice() {
        double originalPrice = getTotalPrice();
        double discount = 0.5;
        double discountedPrice = originalPrice * (1 - discount);
        setTotalPrice(discountedPrice);
        return discountedPrice;
    }


    //최종 가격 가져오기
    public double getTotalPrice(){
        // System.out.println(price);
        // 카트 작성하시고 TotalPrice 연결시켜주세요
        return price;
    }
    public void setTotalPrice(double price){
        this.price = price;
    }

    //최종 메뉴 가져오기
    public List<String> getSelectionMenu() {
        return selectionMenu;
    }
    public void setSelectionMenu(List<String> selectionMenu) {
        this.selectionMenu = selectionMenu;
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

