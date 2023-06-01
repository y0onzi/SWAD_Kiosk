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



}

