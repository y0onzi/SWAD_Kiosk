public class BarcodeReader {
    String CouponCode;
    Controller controller;

    public BarcodeReader() {
    }

    public void readCoupon(String CouponCode){
        this.CouponCode = CouponCode;
        useCoupon(CouponCode);
    }
    private void useCoupon(String CouponCode){
       /*if(CouponCode.equals("2023drinkfree")){
            System.out.println("음료수 무료 제공 쿠폰 적용완료!");
            //controller에서 가격조절필요
            //음료수 선택안했으면? - 일단은 고려X
        }
        else*/ if (CouponCode.equals("2023discount50")){
            System.out.println("주문 가격에서 50퍼센트 할인 적용완료!");
            //controller에서 가격조절필요
            System.out.println("최종 결제 금액은: "+ controller.applyCouponAndGetPrice());
        }

    }
}

